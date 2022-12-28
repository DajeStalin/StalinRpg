package net.stalin.stalinrpg.client.gui.guiscreens.classes;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.client.gui.guiscreens.StatsGui;

import javax.annotation.Nonnull;

public class WarriorClassGui extends Screen {
    public WarriorClassGui(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }

    Button button_next, button_pre, button_select;

    ResourceLocation SELECT_CLASS = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/screens/warrior_screen.png");

    ResourceLocation BUTTON_NEXT = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/buttons/button_right.png");
    ResourceLocation BUTTON_PRE = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/buttons/button_left.png");
    ResourceLocation BUTTON_SELECT = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/buttons/select_class.png");

    @Override
    protected void init() {
        buttons.clear();
        buttons.add(button_next = new ImageButton(this.width / 2 + 75, 130, 55, 25, 0, 0, 0, BUTTON_NEXT, (button) -> {
            Minecraft.getInstance().setScreen(new RogueClassGui(new TranslationTextComponent(StalinRpg.MOD_ID + ".class_rogue")));
        }));
        this.addButton(button_next);
        buttons.add(button_pre = new ImageButton(this.width / 2 - 115, 130, 55, 25, 0, 0, 0, BUTTON_PRE, (button) -> {
            Minecraft.getInstance().setScreen(new RogueClassGui(new TranslationTextComponent(StalinRpg.MOD_ID + ".class_rogue")));
        }));
        this.addButton(button_pre);
        buttons.add(button_select = new ImageButton(this.width / 2 - 28, 128, 55, 25, 0, 0, 0, BUTTON_SELECT, (button) -> {

        }));
        this.addButton(button_select);

        super.init();
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(SELECT_CLASS);
        int textureWidth = 256;
        int textureHeight = 256;
        blit(matrixStack, this.width / 2 - 130, 10, 0, 0, textureWidth, textureHeight);
        this.button_next.render(matrixStack, mouseX, mouseY, partialTicks);
        this.button_pre.render(matrixStack, mouseX, mouseY, partialTicks);
        this.button_select.render(matrixStack, mouseX, mouseY, partialTicks);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
