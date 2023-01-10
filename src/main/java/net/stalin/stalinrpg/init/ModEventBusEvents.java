package net.stalin.stalinrpg.init;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.entities.entity.BuffZombieEntity;
import net.stalin.stalinrpg.entities.ModEntityTypes;

import static net.minecraft.client.gui.AbstractGui.blit;

@Mod.EventBusSubscriber(modid = StalinRpg.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    Minecraft mc = Minecraft.getInstance();
    private static final ResourceLocation IMG_LOCATION = new ResourceLocation("textures/entity/buff_zombie.png");
    protected int screenWidth;
    protected int screenHeight;

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieEntity.setCustomAttributes().build());
    }

    @SubscribeEvent
    public void HUGGYSCREAMER(RenderGameOverlayEvent event) {
        PlayerEntity player = Minecraft.getInstance().player;
        //Options settings = Minecraft.getInstance().options;
        this.screenWidth = this.mc.getWindow().getGuiScaledWidth();
        this.screenHeight = this.mc.getWindow().getGuiScaledHeight();
        assert player != null;
        if (player.hasEffect(Effects.GLOWING)) {

                RenderSystem.disableDepthTest();
                RenderSystem.depthMask(false);
                RenderSystem.enableBlend();
                RenderSystem.blendFunc(770, 771);
                Minecraft.getInstance().getTextureManager().bind(IMG_LOCATION);
                blit(event.getMatrixStack(), 0, 0, 0, 0,screenWidth ,screenHeight, 480, 270);
                RenderSystem.depthMask(true);
                RenderSystem.enableDepthTest();
        }
    }

}
