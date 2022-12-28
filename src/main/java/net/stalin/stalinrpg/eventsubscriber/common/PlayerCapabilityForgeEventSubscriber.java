package net.stalin.stalinrpg.eventsubscriber.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.capability.experiance.IBaseExperienceCapability;
import net.stalin.stalinrpg.capability.experiance.PlayerExperienceCapabilityProvider;
import net.stalin.stalinrpg.init.ModNetwork;
import net.stalin.stalinrpg.network.handler.PlayerExperienceClientServerHandler;
import net.stalin.stalinrpg.util.EventUtils;

import java.util.function.BiConsumer;

@Mod.EventBusSubscriber(modid = StalinRpg.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerCapabilityForgeEventSubscriber {
    public static final ResourceLocation EXP_CAP = new ResourceLocation(StalinRpg.MOD_ID, "experience");

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof PlayerEntity)) {
            return;
        }

        StalinRpg.LOGGER.info("----------------------->ForgeEventSubscriber.attachCapability()");
        event.addCapability(EXP_CAP, new PlayerExperienceCapabilityProvider());
        StalinRpg.LOGGER.info("------------------------>Capabilities attached");
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone e) {
        if (e.isWasDeath()) {
            e.getOriginal().getCapability(PlayerExperienceCapabilityProvider.LEVEL_CAP).ifPresent(originalCap -> {
                e.getPlayer().getCapability(PlayerExperienceCapabilityProvider.LEVEL_CAP).ifPresent(actualCap -> {
                    PlayerEntity originalPlayer = e.getOriginal();
                    PlayerEntity actualPlayer = e.getPlayer();
                    actualCap.setNBTData(originalCap.getNBTData());
                });
            });
        }

    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {

        StalinRpg.LOGGER.info("----------------------->ForgeEventSubscriber.onPlayerRespawn()");
        PlayerEntity player = event.getPlayer();

        if (player.level.isClientSide) {
            return;
        }
        LazyOptional<IBaseExperienceCapability> exp = player
                .getCapability(PlayerExperienceCapabilityProvider.LEVEL_CAP);
    }

    /**
     * Restore client player capabilities' values on join. Applies passive skills to entities
     *
     * @param event
     */
    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if ((event.getEntity() instanceof PlayerEntity)) {
            onPlayerJoinWorld(event);
        }
    }

    private static void onPlayerJoinWorld(EntityJoinWorldEvent event) {
        final PlayerEntity player = (PlayerEntity) event.getEntity();

        if (player.level.isClientSide)
            return;

        StalinRpg.LOGGER.info("----------------------->ForgeEventSubscriber.onEntityJoinWorld()");

        BiConsumer<PlayerEntity, LazyOptional<IBaseExperienceCapability>> expBiConsumer = (aPlayer, theExp) -> {
            ModNetwork.CHANNEL.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) aPlayer),
                    new PlayerExperienceClientServerHandler(theExp.map(x -> x.getNBTData()).orElse(null)));
            StalinRpg.LOGGER.info("----------------------->ForgeEventSubscriber.onEntityJoinWorld().expBiConsumer");
        };
        EventUtils.onJoin(player, expBiConsumer, PlayerExperienceCapabilityProvider.LEVEL_CAP);
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void playerSetSpawnEvent(PlayerSetSpawnEvent event) {
        StalinRpg.LOGGER.info("----------------------->ForgeEventSubscriber.playerSetSpawnEvent()");
        if (event.getNewSpawn() != null) {
            StalinRpg.LOGGER.info(" SPAWN POINT FIRST {}", event.getNewSpawn());

        }
    }
}
