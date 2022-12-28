package net.stalin.stalinrpg;

import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stalin.stalinrpg.client.gui.overlay.*;
import net.stalin.stalinrpg.effect.ModEffects;
import net.stalin.stalinrpg.entities.render.BuffZombieRenderer;
import net.stalin.stalinrpg.entities.ModEntityTypes;
import net.stalin.stalinrpg.init.ModNetwork;
import net.stalin.stalinrpg.item.ItemRegistry;
import net.stalin.stalinrpg.sounds.SoundEventRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StalinRpg.MOD_ID)
public class StalinRpg {
    public static final String MOD_ID = "stalinrpg";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final DamageSource FIRE_DAMAGE = new DamageSource("fireDamage");

    public StalinRpg() {
        LOGGER.info("Initializing StalinRpg");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        ItemRegistry.ITEMS.register(bus);
        net.stalin.stalinrpg.client.gui.ItemRegistry.ITEMS.register(bus);

        ModNetwork.register();
        SoundEventRegistry.register(bus);
        ModEntityTypes.register(bus);
        ModEffects.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new GuiLevelBar());
        MinecraftForge.EVENT_BUS.register(new GuiHealthBar());
        MinecraftForge.EVENT_BUS.register(new GuiExpBar());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieRenderer::new);
    }
}
