package net.stalin.stalinrpg.client.gui.overlay;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.stalin.stalinrpg.StalinRpg;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;

public class GuiHealthBar extends AbstractGui {
    private final static ResourceLocation overlayBar = new ResourceLocation(StalinRpg.MOD_ID + ":textures/gui/overlay/health_bar_alpha.png");
    private final static int TEX_WIDTH = 101;
    private final static int TEX_HEIGHT = 16;
    private Minecraft mc;

    public GuiHealthBar(Minecraft mc) {
        super();
        this.mc = mc;
    }

    public GuiHealthBar() {
        super();
        mc = Minecraft.getInstance();
    }

    public void GuiHealthBarRender(MatrixStack matrixStack, int screenWidth, int screenHeight) {
        PlayerEntity player = mc.player;
        FontRenderer fr = mc.font;
        mc.getTextureManager().bind(overlayBar);
        float oneUnit = (float) TEX_WIDTH / player.getMaxHealth();
        int currentWidth = (int) (oneUnit * player.getHealth());
        blit(matrixStack, 30, 0, 0, 0, TEX_WIDTH, TEX_HEIGHT);
        blit(matrixStack, 31, 0, 1, TEX_HEIGHT, currentWidth, TEX_HEIGHT);


        glPushMatrix();
        float maxHp = player.getMaxHealth();
        float absorptionAmount = player.getAbsorptionAmount();
        float effectiveHp = player.getHealth() + absorptionAmount;
        GL11.glScalef(1, 1, 1);
        String s = (int) effectiveHp + "/" + (int) maxHp;
        fr.draw(matrixStack, s, TEX_WIDTH - 33, 4.5f, 0xFFFFFF);
        glPopMatrix();
    }
}
