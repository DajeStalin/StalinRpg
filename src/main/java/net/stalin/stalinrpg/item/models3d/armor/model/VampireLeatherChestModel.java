package net.stalin.stalinrpg.item.models3d.armor.model;

import net.minecraft.util.ResourceLocation;
import net.stalin.stalinrpg.item.models3d.armor.items.VampireLeatherChestItem;
import net.stalin.stalinrpg.item.models3d.armor.items.VampireLeatherHeadItem;
import net.stalin.stalinrpg.item.models3d.armor.resourcelocation.ArmorResources;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VampireLeatherChestModel extends AnimatedGeoModel<VampireLeatherChestItem> {
    @Override
    public ResourceLocation getModelLocation(VampireLeatherChestItem object) {
        return ArmorResources.VAMPIRE_LEATHER;
    }

    @Override
    public ResourceLocation getTextureLocation(VampireLeatherChestItem object) {
        return ArmorResources.VAMPIRE_LEATHER_TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(VampireLeatherChestItem animatable) {
        return software.bernie.example.client.EntityResources.GECKOARMOR_ANIMATIONS;
    }
}
