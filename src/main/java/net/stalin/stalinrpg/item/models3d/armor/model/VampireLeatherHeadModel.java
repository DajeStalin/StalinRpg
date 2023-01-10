package net.stalin.stalinrpg.item.models3d.armor.model;

import net.minecraft.util.ResourceLocation;
import net.stalin.stalinrpg.item.models3d.armor.items.VampireLeatherHeadItem;
import net.stalin.stalinrpg.item.models3d.armor.resourcelocation.ArmorResources;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VampireLeatherHeadModel extends AnimatedGeoModel<VampireLeatherHeadItem> {
    @Override
    public ResourceLocation getModelLocation(VampireLeatherHeadItem object) {
        return ArmorResources.VAMPIRE_LEATHER;
    }

    @Override
    public ResourceLocation getTextureLocation(VampireLeatherHeadItem object) {
        return ArmorResources.VAMPIRE_LEATHER_TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(VampireLeatherHeadItem animatable) {
        return software.bernie.example.client.EntityResources.GECKOARMOR_ANIMATIONS;
    }
}
