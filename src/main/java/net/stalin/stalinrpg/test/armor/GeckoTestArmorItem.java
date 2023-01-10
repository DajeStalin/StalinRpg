package net.stalin.stalinrpg.test.armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ibm.icu.text.PluralRules;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.stalin.stalinrpg.item.models3d._3DArmorModGroup;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.*;



public class GeckoTestArmorItem extends GeoArmorItem implements IAnimatable {
    public AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public GeckoTestArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder.tab(_3DArmorModGroup.ARMOR_3D));
    }

    // Predicate runs every frame
    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        // This is all the extradata this event carries. The livingentity is the entity
        // that's wearing the armor. The itemstack and equipmentslottype are self
        // explanatory.
        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);

        // Always loop the animation but later on in this method we'll decide whether or
        // not to actually play it
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.potato_armor.new", ILoopType.EDefaultLoopTypes.LOOP));

        // If the living entity is an armorstand just play the animation nonstop
        if (livingEntity instanceof ArmorStandEntity) {
            return PlayState.CONTINUE;
        }


        // elements 2 to 6 are the armor so we take the sublist. Armorlist now only
        // contains the 4 armor slots
        List<Item> armorList = new ArrayList<>(4);
        for(EquipmentSlotType slot : EquipmentSlotType.values()) {
            if(slot.getType() == EquipmentSlotType.Group.ARMOR) {
                if(livingEntity.getItemBySlot(slot) != null) {
                    armorList.add(livingEntity.getItemBySlot(slot).getItem());
                }
            }
        }

        // Make sure the player is wearing all the armor. If they are, continue playing
        // the animation, otherwise stop
        boolean isWearingAll = armorList
                .containsAll(Arrays.asList(ItemRegistry.TEST_BOOTS.get(), ItemRegistry.TEST_LEGGINGS.get(),
                        ItemRegistry.TEST_CHEST.get(), ItemRegistry.TEST_HEAD.get()));
        return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
    }

    // All you need to do here is add your animation controllers to the
    // AnimationData
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<GeckoTestArmorItem>(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

//    @Override
//    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
//
//        if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ItemRegistry.TEST_HEAD.get() &&
//                player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ItemRegistry.TEST_CHEST.get() &&
//                player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ItemRegistry.TEST_LEGGINGS.get() &&
//                player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.TEST_BOOTS.get()) {
////            player.addEffect(new EffectInstance(Effects.INVISIBILITY, 10, 3));
//            player.addEffect(new EffectInstance(Effects.REGENERATION, 10, 3));
//        }
//
//        super.onArmorTick(stack, world, player);
//    }

    //    @Override
//    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
//        Multimap<Attribute, AttributeModifier> map = HashMultimap.create();
//
//        if (slot == EquipmentSlotType.HEAD) {
//            map.put(Attributes.MAX_HEALTH,
//                    new AttributeModifier(new UUID(171328, slot.getIndex()), "Armor modifier" + slot, 5,
//                            AttributeModifier.Operation.fromValue(0)));
//            map.put(Attributes.ARMOR,
//                    new AttributeModifier(new UUID(171328, slot.getIndex()), "Armor modifier" + slot, 6,
//                            AttributeModifier.Operation.fromValue(0)));
//            map.put(Attributes.ARMOR_TOUGHNESS,
//                    new AttributeModifier(new UUID(171328, slot.getIndex()), "Armor modifier" + slot, 2,
//                            AttributeModifier.Operation.fromValue(0)));
////            return super.getAttributeModifiers(slot, stack);
//        }
//        return map;
//    }
}
