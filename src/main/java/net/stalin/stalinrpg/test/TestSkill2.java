package net.stalin.stalinrpg.test;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.stalin.stalinrpg.item.ModGroup;

import javax.annotation.Nonnull;
import java.util.List;

public class TestSkill2 extends Item {
    public TestSkill2() {
        super(new Properties().tab(ModGroup.STALINRPG));
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, @Nonnull Hand handIn) {

        double x = playerIn.getX();
        double y = playerIn.getY();
        double z = playerIn.getZ();
        double radius = 10D;
        double cRadius = 20D;

        List<Entity> mobs = worldIn.getEntities(playerIn, new AxisAlignedBB(x - radius,y - radius,z - radius,x + radius,y + radius,z + radius));
        for (Entity mob : mobs) {
            if (mob.getEntity() instanceof IMob) {
                LivingEntity livingEntity = (LivingEntity) mob.getEntity();

                double X = livingEntity.getX();
                double Y = livingEntity.getY();
                double Z = livingEntity.getZ();
            }
        }

        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(4.5) * cRadius, y + 0.2, z  + Math.toRadians(9) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(-4.5) * cRadius, y + 0.2, z  + Math.toRadians(9) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(8) * cRadius, y + 0.2, z  + Math.toRadians(6.25) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(-8) * cRadius, y + 0.2, z  + Math.toRadians(6.25) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(10) * cRadius, y + 0.2, z  + Math.toRadians(3.5) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(-10) * cRadius, y + 0.2, z  + Math.toRadians(3.5) * cRadius, 0,0,0);

        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(4.5) * cRadius, y + 0.2, z + Math.toRadians(-9) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(-4.5) * cRadius, y + 0.2, z + Math.toRadians(-9) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(8) * cRadius, y + 0.2, z + Math.toRadians(-6.25) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(-8) * cRadius, y + 0.2, z + Math.toRadians(-6.25) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(10) * cRadius, y + 0.2, z + Math.toRadians(-3.5) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(-10) * cRadius, y + 0.2, z + Math.toRadians(-3.5) * cRadius, 0,0,0);

        // Ось X
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(10.5) * cRadius, y + 0.2, z, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x + Math.toRadians(-10.5) * cRadius, y + 0.2, z, 0,0,0);
        // Ось Z
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y + 0.2, z + Math.toRadians(10.5) * cRadius, 0,0,0);
        worldIn.addParticle(ParticleTypes.SOUL_FIRE_FLAME, x, y + 0.2, z + Math.toRadians(-10.5) * cRadius, 0,0,0);
        
        return super.use(worldIn, playerIn, handIn);
    }
}
