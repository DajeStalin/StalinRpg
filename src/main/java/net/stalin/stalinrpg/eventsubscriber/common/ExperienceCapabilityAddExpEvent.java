package net.stalin.stalinrpg.eventsubscriber.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.capability.IGenericCapability;
import net.stalin.stalinrpg.capability.experiance.IBaseExperienceCapability;
import net.stalin.stalinrpg.capability.experiance.PlayerExperienceCapabilityProvider;
import net.stalin.stalinrpg.client.gui.OpenGUI;
import net.stalin.stalinrpg.client.gui.guiscreens.SelectClassGui;
import net.stalin.stalinrpg.client.gui.guiscreens.UpgradeStatsGui;
import net.stalin.stalinrpg.effect.ModEffects;

import java.util.Objects;
import java.util.Random;

import static net.minecraft.entity.ai.attributes.Attributes.MAX_HEALTH;

@Mod.EventBusSubscriber(modid = StalinRpg.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExperienceCapabilityAddExpEvent {

    // Когда сущность умирает
    @SubscribeEvent
    public static void onEntityDeathWorld(LivingDeathEvent event) {
        if ((event.getEntity() instanceof MobEntity)) {
            levelUp(event);
            StalinRpg.LOGGER.info("----->Death is mob");
        }
        if ((event.getEntity() instanceof PlayerEntity)) {
            StalinRpg.LOGGER.info("----->Death is player");
        }
    }

    // Рандом экспы
    public static int randomExp() {
        Random r = new Random();
        int min = 1;
        int max = 20;
        return 50 + r.nextInt(max - min + 1) + min;
    }

    // генерация случайного колличества поинтов
    public static int randomPoints(){
        int a = 1;
        int b = 5;
        int random_number1 = a + (int) (Math.random() * b);
        return random_number1;
    }

    private static void levelUp(LivingDeathEvent event) {
        MobEntity mobEntity = (MobEntity) event.getEntity();
        DamageSource damageSource = mobEntity.getLastDamageSource();
        if (damageSource != null) {
            if (damageSource.getEntity() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) damageSource.getEntity();
                levelChange(player);
            }
        }
    }

    private static void levelChange(PlayerEntity player) {
        IBaseExperienceCapability expCap = IGenericCapability.getUnwrappedCapability(player,
                PlayerExperienceCapabilityProvider.LEVEL_CAP);

        int currentLevel = expCap.getCurrentLevel();
        int currentExp = expCap.getExperience();
        int levelChange = expCap.getLevelChange();
        float maxHp = player.getMaxHealth();
        float hpAdd = 5 * currentLevel;

        expCap.addExperience(randomExp(), player);
        expCap.addPoints(randomPoints(), player);

        if (currentExp >= levelChange) {
            expCap.addLevel(1, player);
            expCap.setExperience(currentExp - levelChange, player);
            expCap.setLevelChange(levelChange, player);
            expCap.addPoints(randomPoints(), player);

            expCap.setMaxHealth(hpAdd, maxHp, player);
        }
    }

    @SubscribeEvent
    public static void setHpAfterDeath(PlayerEvent.Clone event) {
        PlayerEntity player = event.getPlayer();
        PlayerEntity oldPlayer = event.getOriginal();
        float oldHp = oldPlayer.getMaxHealth();
        Objects.requireNonNull(((LivingEntity) player).getAttribute(MAX_HEALTH)).setBaseValue(oldHp);
        player.setHealth(oldHp / 2);
    }



//    @SubscribeEvent
//    public static void updateEffectsCheck(LivingEvent.LivingUpdateEvent event) {
//        Minecraft mc = Minecraft.getInstance();
//        World worldIn = mc.level;
//        if (event.getEntity() instanceof MobEntity) {
//            MobEntity entity = (MobEntity) event.getEntity();
//            double xX = entity.getX();
//            double yY = entity.getY();
//            double zZ = entity.getZ();
//            double radius = 5;
//        }
//    }

    // Реген хп
//    @SubscribeEvent
//    public static void CustomRegen(LivingHealEvent event) {
//        event.setAmount(0.1F);
//    }

//    @SubscribeEvent
//    public static void damageSource2(LivingHurtEvent event) {
//        DamageSource source = event.getSource().setExplosion();
//        event.setAmount(5);
////        if (source == OUT_OF_WORLD) {
////            event.setCanceled(true);
////        } else {
////            if (event.getEntity() instanceof PlayerEntity) {
////                // Когда бьют игрока
////                StalinRpg.LOGGER.info("-------->HurtEvent PlayerEntity");
////            }
////            if (event.getEntity() instanceof MobEntity) {
////                // Когда бьют моба
////                StalinRpg.LOGGER.info("-------->HurtEvent MobEntity");
////                StalinRpg.LOGGER.info("-------->HurtEvent: " + event.getAmount());
////
////            }
////        }
//    }
}
