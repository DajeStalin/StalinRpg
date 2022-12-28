package net.stalin.stalinrpg.eventsubscriber.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.client.gui.guiscreens.SelectClassGui;
import net.stalin.stalinrpg.client.gui.guiscreens.UpgradeStatsGui;
import net.stalin.stalinrpg.client.gui.overlay.GuiExpBar;
import net.stalin.stalinrpg.client.gui.overlay.GuiHealthBar;
import net.stalin.stalinrpg.client.gui.overlay.GuiLevelBar;

@Mod.EventBusSubscriber(modid = StalinRpg.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class ClientForgeEventSubscriber {
    private static GuiHealthBar guiHealthBar = new GuiHealthBar();
    private static GuiLevelBar guiLevelBar = new GuiLevelBar();
    private static GuiExpBar guiExpBar = new GuiExpBar();
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onEvent(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            guiHealthBar.GuiHealthBarRender(event.getMatrixStack(), event.getWindow().getGuiScaledWidth(),
                    event.getWindow().getGuiScaledHeight());
            guiLevelBar.GuiLevelBarRender(event.getMatrixStack(), event.getWindow().getGuiScaledWidth(),
                    event.getWindow().getGuiScaledHeight());
            guiExpBar.GuiExpBarRender(event.getMatrixStack(), event.getWindow().getGuiScaledWidth(),
                    event.getWindow().getGuiScaledHeight());
        }

        if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {
//            guiHealthBar.GuiHealthBarRender(event.getMatrixStack(), event.getWindow().getGuiScaledWidth(),
//                    event.getWindow().getGuiScaledHeight());
            event.setCanceled(true);
        }
    }
}
