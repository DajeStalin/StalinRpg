package net.stalin.stalinrpg.test;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.item.ModGroup;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;


public class TestSkill1 extends Item {
    public TestSkill1() {
        super(new Properties().tab(ModGroup.STALINRPG));
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> use(@Nonnull World worldIn, @Nonnull PlayerEntity playerIn, @Nonnull Hand handIn) {

        double x = playerIn.getX();
        double y = playerIn.getY();
        double z = playerIn.getZ();
        double radius = 10D;


        List<Entity> mobs = worldIn.getEntities(playerIn, new AxisAlignedBB(x - radius,y - radius,z - radius,x + radius,y + radius,z + radius));
        float[] mobsArray2 = new float[mobs.size()];
        for (int i = 0; i < mobs.size(); i++) {
            if (mobs.get(i).getEntity() instanceof IMob) {
                Entity entity = mobs.get(i).getEntity();
                LivingEntity livingEntity = (LivingEntity) entity.getEntity();
                mobsArray2[i] = livingEntity.distanceTo(playerIn);

                if (worldIn.isClientSide) {
                    StalinRpg.LOGGER.info("Mobs Array: " + entity);
                }
            }
        }

        Arrays.sort(mobsArray2);

        for (Entity mob : mobs) {
            if (mob.getEntity() instanceof IMob) {
                Entity entity = mob.getEntity();
                LivingEntity livingEntity = (LivingEntity) entity.getEntity();
                if (livingEntity.distanceTo(playerIn) == mobsArray2[0]) {
                    double xM = livingEntity.getX();
                    double zM = livingEntity.getZ();

                    Vector3d vector3d = livingEntity.getLookAngle();
                    Vector3d vector3d1 = playerIn.getLookAngle();

                    double vecX = vector3d.x;
                    double vecZ = vector3d.z;

                    double vecXp = vector3d1.x;
                    double vecZp = vector3d1.z;

//                    StalinRpg.LOGGER.info("X mob: " + vecX);
//                    StalinRpg.LOGGER.info("Z mob: " + vecZ);

                    if (worldIn.isClientSide) {
                        StalinRpg.LOGGER.info("X player: " + vecXp);
                        StalinRpg.LOGGER.info("Z player: " + vecZp);
                    }

//                    playerIn.setDeltaMovement(vecXp, 0, vecZp);
                }
            }
        }

        if (worldIn.isClientSide) {
            StalinRpg.LOGGER.info("Mobs Array: " + Arrays.toString(mobsArray2));
        }




        return super.use(worldIn, playerIn, handIn);
    }
}
