package net.stalin.stalinrpg.item.models3d.armor.model;

import net.minecraft.util.ResourceLocation;
import net.stalin.stalinrpg.item.models3d.armor.items.VampireLeatherBootsItem;
import net.stalin.stalinrpg.item.models3d.armor.resourcelocation.ArmorResources;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VampireLeatherBootsModel extends AnimatedGeoModel<VampireLeatherBootsItem> {
    @Override
    public ResourceLocation getModelLocation(VampireLeatherBootsItem object) {
        return ArmorResources.VAMPIRE_LEATHER;
    }

    @Override
    public ResourceLocation getTextureLocation(VampireLeatherBootsItem object) {
        return ArmorResources.VAMPIRE_LEATHER_TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(VampireLeatherBootsItem animatable) {
        return software.bernie.example.client.EntityResources.GECKOARMOR_ANIMATIONS;
    }
}
