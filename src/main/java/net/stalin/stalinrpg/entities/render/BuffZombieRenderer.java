package net.stalin.stalinrpg.entities.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.entities.entity.BuffZombieEntity;
import net.stalin.stalinrpg.entities.models.BuffZombieModel;

public class BuffZombieRenderer extends MobRenderer<BuffZombieEntity, BuffZombieModel<BuffZombieEntity>> {

    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(StalinRpg.MOD_ID, "textures/entity/buff_zombie.png");

    public BuffZombieRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BuffZombieModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(BuffZombieEntity entity) {
        return TEXTURE;
    }
}
