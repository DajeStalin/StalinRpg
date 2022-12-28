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

public class MainHubGui extends Screen {
    Button button_open_stats, button_open_stats_upgrade, button_open_select_class;
    ResourceLocation MENU_HUB = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/screens/menu_hub.png");
    ResourceLocation BUTTON_OPEN_STATS = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/buttons/buttons_stats.png");
    ResourceLocation BUTTON_OPEN_STATS_UPGRADE = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/buttons/button_upgrade_stats.png");
    ResourceLocation BUTTON_OPEN_SELECT_CLASS = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/buttons/button_select_class.png");

    @Override
    protected void init() {
        buttons.clear();
        buttons.add(button_open_stats = new ImageButton(this.width / 2 - 110, 65, 55, 25, 0, 0, 0, BUTTON_OPEN_STATS, (button) -> {
            Minecraft.getInstance().setScreen(new StatsGui(new TranslationTextComponent(StalinRpg.MOD_ID + ".stats_hub")));
        }));
        this.addButton(button_open_stats);
        buttons.add(button_open_stats_upgrade = new ImageButton(this.width / 2 - 46, 65, 55, 25, 0, 0, 0, BUTTON_OPEN_STATS_UPGRADE, (button) -> {
            Minecraft.getInstance().setScreen(new UpgradeStatsGui(new TranslationTextComponent(StalinRpg.MOD_ID + ".stats_hub_upgrade")));
        }));
        this.addButton(button_open_stats_upgrade);
        buttons.add(button_open_select_class = new ImageButton(this.width / 2 + 17, 65, 55, 25, 0, 0, 0, BUTTON_OPEN_SELECT_CLASS, (button) -> {
            Minecraft.getInstance().setScreen(new SelectClassGui(new TranslationTextComponent(StalinRpg.MOD_ID + ".select_class")));
        }));
        this.addButton(button_open_select_class);

        super.init();
    }

    public MainHubGui(ITextComponent titleIn) {
        super(titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(MENU_HUB);
        int textureWidth = 256;
        int textureHeight = 156;
        blit(matrixStack, this.width / 2 - 130, 10, 0, 0, textureWidth, textureHeight);
        this.button_open_stats.render(matrixStack, mouseX, mouseY, partialTicks);
        this.button_open_stats_upgrade.render(matrixStack, mouseX, mouseY, partialTicks);
        this.button_open_select_class.render(matrixStack, mouseX, mouseY, partialTicks);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
