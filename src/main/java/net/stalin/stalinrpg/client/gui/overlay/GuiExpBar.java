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

public class GuiExpBar extends AbstractGui {
    private final static ResourceLocation overlayBar = new ResourceLocation(StalinRpg.MOD_ID + ":textures/gui/overlay/experience_bar_alpha.png");
    private final static int TEX_WIDTH = 86;
    private final static int TEX_HEIGHT = 14;
    private Minecraft mc;

    public GuiExpBar(Minecraft mc) {
        super();
        this.mc = mc;
    }

    public GuiExpBar() {
        super();
        mc = Minecraft.getInstance();
    }

    public void GuiExpBarRender(MatrixStack matrixStack, int screenWidth, int screenHeight) {
        World world = mc.level;
        PlayerEntity player = mc.player;
        FontRenderer fr = mc.font;
        mc.getTextureManager().bind(overlayBar);
        IBaseExperienceCapability expCap = IGenericCapability.getUnwrappedCapability(player, PlayerExperienceCapabilityProvider.LEVEL_CAP);
        float oneUnit = (float) TEX_WIDTH / expCap.getLevelChange();
        int currentWidth = (int) (oneUnit * expCap.getExperience());
        blit(matrixStack, 30, 16, 0, 0, TEX_WIDTH, TEX_HEIGHT);
        blit(matrixStack, 31, 16, 1, TEX_HEIGHT, currentWidth, TEX_HEIGHT);


        glPushMatrix();
        float maxExp = expCap.getLevelChange();
        float effectiveExp = expCap.getExperience();
        GL11.glScalef(1, 1, 1);
        String s = (int) effectiveExp + "/" + (int) maxExp;
        /* Тень */
//        fr.draw(matrixStack, s, TEX_WIDTH - 20, 5, 0x5A2B00);
        /* Основной текст */
        fr.draw(matrixStack, s, TEX_WIDTH - 28, 19, 0xFFFFFF);
        glPopMatrix();
    }
}
