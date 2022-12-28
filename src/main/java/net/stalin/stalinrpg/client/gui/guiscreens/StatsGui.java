package net.stalin.stalinrpg.client.gui.guiscreens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.stalin.stalinrpg.StalinRpg;

import static net.minecraft.entity.ai.attributes.Attributes.*;

public class StatsGui extends Screen {

    float max_hp = Minecraft.getInstance().player.getMaxHealth();
    float max_armors = Minecraft.getInstance().player.getArmorValue();

    float resist = (float) Minecraft.getInstance().player.getAttribute(ARMOR_TOUGHNESS).getBaseValue();
    float damage = (float) Minecraft.getInstance().player.getAttribute(ATTACK_DAMAGE).getBaseValue();
    float attack_sp = (float) Minecraft.getInstance().player.getAttribute(ATTACK_SPEED).getBaseValue();
    TranslationTextComponent max_health = new TranslationTextComponent(String.valueOf((int) max_hp));
    TranslationTextComponent max_armor = new TranslationTextComponent(String.valueOf((int) max_armors));

    TranslationTextComponent max_resist = new TranslationTextComponent(String.valueOf((int) max_armors));
    TranslationTextComponent attack_damage = new TranslationTextComponent(String.valueOf((int) damage));
    TranslationTextComponent attack_speed = new TranslationTextComponent(String.valueOf((int) attack_sp));

    protected StatsGui(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }

    ResourceLocation STATS_HUB = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/screens/menu_stats.png");

    @Override
    protected void init() {

        super.init();
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(STATS_HUB);
        int textureWidth = 256;
        int textureHeight = 156;
        blit(matrixStack, this.width / 2 - 130, 10, 0, 0, textureWidth, textureHeight);
        drawCenteredString(matrixStack, this.font, max_health, this.width / 2 - 28, 70, 0xf44236);
        drawCenteredString(matrixStack, this.font, max_armor, this.width / 2 - 28, 89, 0xf44236);
        drawCenteredString(matrixStack, this.font, max_resist, this.width / 2 - 28, 107, 0xf44236);
        drawCenteredString(matrixStack, this.font, attack_damage, this.width / 2 + 93, 70, 0xf44236);
        drawCenteredString(matrixStack, this.font, attack_speed, this.width / 2 + 93, 89, 0xf44236);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
