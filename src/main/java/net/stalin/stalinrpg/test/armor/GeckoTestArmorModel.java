package net.stalin.stalinrpg.test.armor;

import net.minecraft.util.ResourceLocation;
import net.stalin.stalinrpg.item.models3d.armor.resourcelocation.ArmorResources;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GeckoTestArmorModel extends AnimatedGeoModel<GeckoTestArmorItem> {

    @Override
    public ResourceLocation getModelLocation(GeckoTestArmorItem object) {
        return ArmorResources.GECKOARMOR_MODEL_TEST;
    }

    @Override
    public ResourceLocation getTextureLocation(GeckoTestArmorItem object) {
        return ArmorResources.GECKOARMOR_TEXTURE_TEST;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GeckoTestArmorItem animatable) {
        return software.bernie.example.client.EntityResources.GECKOARMOR_ANIMATIONS;
    }
}
