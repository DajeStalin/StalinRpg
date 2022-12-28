package net.stalin.stalinrpg.client.gui.guiscreens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.capability.IGenericCapability;
import net.stalin.stalinrpg.capability.experiance.IBaseExperienceCapability;
import net.stalin.stalinrpg.capability.experiance.PlayerExperienceCapabilityProvider;
import net.stalin.stalinrpg.network.networking.Networking;
import net.stalin.stalinrpg.network.networking.stats.SendPackAddStrength;

import javax.annotation.Nonnull;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = StalinRpg.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UpgradeStatsGui extends Screen {
    public UpgradeStatsGui(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }

    World world = Minecraft.getInstance().level;
    PlayerEntity player = Minecraft.getInstance().player;
    FontRenderer fr = Minecraft.getInstance().font;
    IBaseExperienceCapability expCap = IGenericCapability.getUnwrappedCapability(player,
            PlayerExperienceCapabilityProvider.LEVEL_CAP);
    float strength = expCap.getStrength();
    float points = expCap.getPoints();
    float betterPoints = expCap.getBetterPoints();
    TranslationTextComponent current_strength = new TranslationTextComponent("Str: " + (int) strength);
    TranslationTextComponent current_points= new TranslationTextComponent(String.valueOf((int) points));
    TranslationTextComponent current_betterPoints = new TranslationTextComponent(String.valueOf((int) betterPoints));
    Button addStrength;
    ResourceLocation STATS_HUB_UPGRADE = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/screens/menu_stats_upgrade.png");
    ResourceLocation BUTTON_ADD_STATS = new ResourceLocation(StalinRpg.MOD_ID, "textures/gui/menu/buttons/buttons_stats_add.png");


    public void addToStr(PlayerEntity playerIn) {
        IBaseExperienceCapability expCap = IGenericCapability.getUnwrappedCapability(playerIn,
                PlayerExperienceCapabilityProvider.LEVEL_CAP);
        float currentPoints = expCap.getPoints();
        if (currentPoints > 0) {
            float maxHp = playerIn.getMaxHealth();
            UUID uuid = playerIn.getUUID();
            expCap.removePoints(1, playerIn);
            expCap.addStrength(1, playerIn);
            Minecraft.getInstance().setScreen(new UpgradeStatsGui(new TranslationTextComponent(StalinRpg.MOD_ID + ".stats_hub_upgrade")));
            Networking.INSTANCE.sendToServer(new SendPackAddStrength(maxHp, 1, uuid));
        }
    }

    @Override
    protected void init() {
        buttons.clear();
        buttons.add(addStrength = new ImageButton(this.width / 2 - 70, 89, 9, 9, 0, 0, 0, BUTTON_ADD_STATS, (button) -> {
            addToStr(player);
        }));
        this.addButton(addStrength);

        super.init();
    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(STATS_HUB_UPGRADE);
        int textureWidth = 256;
        int textureHeight = 156;
        blit(matrixStack, this.width / 2 - 130, 10, 0, 0, textureWidth, textureHeight);
        this.addStrength.render(matrixStack, mouseX, mouseY, partialTicks);
        fr.draw(matrixStack, current_strength, this.width / 2F - 115F, 90, 0xd50000);
        fr.draw(matrixStack, current_points, this.width / 2F - 79.5F, 33, 0xd50000);
        fr.draw(matrixStack, current_betterPoints, this.width / 2F + 79.5F, 33, 0xd50000);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
