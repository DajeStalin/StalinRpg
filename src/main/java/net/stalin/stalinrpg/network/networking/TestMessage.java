package net.stalin.stalinrpg.network.networking;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.effect.ModEffects;
import net.stalin.stalinrpg.item.ModGroup;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.Timer;


public class TestMessage extends Item {

    public TestMessage() {
        super(new Properties().tab(ModGroup.STALINRPG));
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> use(@Nonnull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {

        double x = playerIn.getX();
        double y = playerIn.getY();
        double z = playerIn.getZ();
        double radius = 20D;
        double cRadius = 5D;

        List<Entity> mobs = worldIn.getEntities(playerIn, new AxisAlignedBB(x - radius,y - radius,z - radius,x + radius,y + radius,z + radius));
        for (Entity mob : mobs) {
            if (mob.getEntity() instanceof IMob) {
                Entity entity = mob.getEntity();
                LivingEntity livingEntity = (LivingEntity) entity.getEntity();

                livingEntity.addEffect(new EffectInstance(ModEffects.FREEZE.get(), 225, 1));
                livingEntity.addEffect(new EffectInstance(Effects.WEAKNESS, 225, 999));

                Timer timer;
                TimerTask mTimerTask;
                timer = new Timer();
                if (worldIn.isClientSide) {
                    mTimerTask = new TimerTask() {
                        int countdownStarter = 22;
                        @Override
                        public void run() {

                            double xX = entity.getX();
                            double yY = entity.getY();
                            double zZ = entity.getZ();

                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(0) * cRadius, yY + 3, zZ, 0,0,0);

                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(4.5) * cRadius, yY + 2.5, zZ  + Math.toRadians(9) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(-4.5) * cRadius, yY + 2.5, zZ  + Math.toRadians(9) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(8) * cRadius, yY + 2.5, zZ  + Math.toRadians(6.25) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(-8) * cRadius, yY + 2.5, zZ  + Math.toRadians(6.25) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(10) * cRadius, yY + 2.5, zZ  + Math.toRadians(3.5) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(-10) * cRadius, yY + 2.5, zZ  + Math.toRadians(3.5) * cRadius, 0,0,0);

                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(4.5) * cRadius, yY + 2.5, zZ + Math.toRadians(-9) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(-4.5) * cRadius, yY + 2.5, zZ + Math.toRadians(-9) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(8) * cRadius, yY + 2.5, zZ + Math.toRadians(-6.25) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(-8) * cRadius, yY + 2.5, zZ + Math.toRadians(-6.25) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(10) * cRadius, yY + 2.5, zZ + Math.toRadians(-3.5) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(-10) * cRadius, yY + 2.5, zZ + Math.toRadians(-3.5) * cRadius, 0,0,0);

                            // Ось X
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(10) * cRadius, yY + 2.5, zZ, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX + Math.toRadians(-10) * cRadius, yY + 2.5, zZ, 0,0,0);
                            // Ось Z
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX, yY + 2.5, zZ + Math.toRadians(10) * cRadius, 0,0,0);
                            worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, xX, yY + 2.5, zZ + Math.toRadians(-10) * cRadius, 0,0,0);
                            countdownStarter--;

                            if (countdownStarter < 0) {
                                StalinRpg.LOGGER.info("Timer Over!");
                                timer.cancel();
                            }
                        }
                    };
                    timer.scheduleAtFixedRate(mTimerTask, 0, 500);
                }

//                worldIn.playSound(playerIn, playerIn, SoundEventRegistry.EXPLOSION.get(), SoundCategory.AMBIENT, 1, 1);
//
//                LightningBoltEntity lightningBolt = EntityType.LIGHTNING_BOLT.create(worldIn);
//                lightningBolt.setPos(xX, yY, zZ);
//                worldIn.addFreshEntity(lightningBolt);
            }
        }



        /* Типа полёт
        Vector3d vec3 = playerIn.getViewVector(0f);
        playerIn.push(vec3.x, vec3.y, vec3.z);
        */


        return super.use(worldIn, playerIn, handIn);
    }
}
