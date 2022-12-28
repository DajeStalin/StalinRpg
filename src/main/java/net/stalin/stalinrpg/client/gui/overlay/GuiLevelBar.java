package net.stalin.stalinrpg.client.gui.overlay;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.capability.IGenericCapability;
import net.stalin.stalinrpg.capability.experiance.IBaseExperienceCapability;
import net.stalin.stalinrpg.capability.experiance.PlayerExperienceCapabilityProvider;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

public class GuiLevelBar extends AbstractGui {
    private final static ResourceLocation overlayBar = new ResourceLocation(StalinRpg.MOD_ID + ":textures/gui/overlay/level_bar.png");
    private final static int TEX_WIDTH = 30;
    private final static int TEX_HEIGHT = 30;
    private Minecraft mc;

    public GuiLevelBar(Minecraft mc) {
        super();
        this.mc = mc;
    }

    public GuiLevelBar() {
        super();
        mc = Minecraft.getInstance();
    }

    public void GuiLevelBarRender(MatrixStack matrixStack, int screenWidth, int screenHeight){
        World world = mc.level;
        PlayerEntity player = mc.player;
        FontRenderer fr = mc.font;
        mc.getTextureManager().bind(overlayBar);
        blit(matrixStack, 0, 0, 0, 0, TEX_WIDTH, TEX_HEIGHT);

        glPushMatrix();
        IBaseExperienceCapability expCap = IGenericCapability.getUnwrappedCapability(player, PlayerExperienceCapabilityProvider.LEVEL_CAP);
        int level = expCap.getCurrentLevel();
        GL11.glScalef(1, 1, 1);
        String s = String.valueOf(level);
        fr.draw(matrixStack, s, TEX_WIDTH - 18, 11, 0x9eff36);
        glPopMatrix();
    }
}
