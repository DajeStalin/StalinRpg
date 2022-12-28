package net.stalin.stalinrpg.client.gui.guiscreens;

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
import net.stalin.stalinrpg.client.gui.guiscreens.classes.RogueClassGui;
import net.stalin.stalinrpg.client.gui.guiscreens.classes.WarriorClassGui;

import javax.annotation.Nonnull;

public class SelectClassGui extends Screen {
    public SelectClassGui(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }
    Button button_open_class_warrior, button_open_class_rogue;
    ResourceLocation SELECT_CLASS = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/screens/select_class.png");
    ResourceLocation BUTTON_OPEN_CLASS_WARRIOR = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/buttons/button_select_warrior.png");

    ResourceLocation BUTTON_OPEN_CLASS_ROGUE = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/buttons/select_class_rogue.png");

    @Override
    protected void init() {
        buttons.clear();
        buttons.add(button_open_class_warrior = new ImageButton(this.width / 2 - 110, 65, 55, 25, 0, 0, 0, BUTTON_OPEN_CLASS_WARRIOR, (button) -> {
            Minecraft.getInstance().setScreen(new WarriorClassGui(new TranslationTextComponent(StalinRpg.MOD_ID + ".class_warrior")));
        }));
        this.addButton(button_open_class_warrior);
        buttons.add(button_open_class_rogue = new ImageButton(this.width / 2 - 46, 65, 55, 25, 0, 0, 0, BUTTON_OPEN_CLASS_ROGUE, (button) -> {
            Minecraft.getInstance().setScreen(new RogueClassGui(new TranslationTextComponent(StalinRpg.MOD_ID + ".class_rogue")));
        }));
        this.addButton(button_open_class_rogue);

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
        this.button_open_class_warrior.render(matrixStack, mouseX, mouseY, partialTicks);
        this.button_open_class_rogue.render(matrixStack, mouseX, mouseY, partialTicks);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
