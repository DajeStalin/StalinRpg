//package net.stalin.stalinrpg.entities;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.entity.AgeableEntity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.MobEntity;
//import net.minecraft.entity.ai.attributes.AttributeModifierMap;
//import net.minecraft.entity.ai.attributes.Attributes;
//import net.minecraft.entity.ai.goal.*;
//import net.minecraft.entity.passive.AnimalEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.Items;
//import net.minecraft.item.crafting.Ingredient;
//import net.minecraft.util.DamageSource;
//import net.minecraft.util.SoundEvent;
//import net.minecraft.util.SoundEvents;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraft.world.server.ServerWorld;
//import net.stalin.stalinrpg.init.ModEntityType;
//
//import javax.annotation.Nullable;
//
//public class HogEntity extends AnimalEntity {
//
//    private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.CARROT, Items.POTATO, Items.BEETROOT);
//
//    public HogEntity(EntityType<? extends AnimalEntity> p_i48568_1_, World p_i48568_2_) {
//        super(p_i48568_1_, p_i48568_2_);
//    }
//
//    //func_233666_p_ ---> registerAttributes()
//    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
//        return MobEntity.createMobAttributes()
//                .add(Attributes.MAX_HEALTH, 10.0D)
//                .add(Attributes.MOVEMENT_SPEED, 0.25D);
//    }
//
//    @Override
//    protected void registerGoals() {
//        super.registerGoals();
//        this.goalSelector.addGoal(0, new SwimGoal(this));
//        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
//        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
//        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, TEMPTATION_ITEMS, false));
//        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
//        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
//        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
//        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
//    }
//
//    @Override
//    protected int getExperienceReward(PlayerEntity p_70693_1_) {
//        return 1 + this.level.random.nextInt(4);
//    }
//
//    @Override
//    protected SoundEvent getAmbientSound() {
//        return SoundEvents.PIG_AMBIENT;
//    }
//
//    @Override
//    protected SoundEvent getDeathSound() {
//        return SoundEvents.PIG_DEATH;
//    }
//
//    @Override
//    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
//        return SoundEvents.PIG_HURT;
//    }
//
//    @Override
//    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
//        this.playSound(SoundEvents.PIG_STEP, 0.15F, 1.0F);
//    }
//
//
//    @Nullable
//    @Override
//    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
//        return ModEntityType.HOG.get().create(this.level);
//    }
//}
