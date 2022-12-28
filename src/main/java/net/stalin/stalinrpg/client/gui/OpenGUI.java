package net.stalin.stalinrpg.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TranslationTextComponent;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.client.gui.guiscreens.MainHubGui;

public class OpenGUI {
    public OpenGUI() {
        Minecraft.getInstance().setScreen(new MainHubGui(new TranslationTextComponent(StalinRpg.MOD_ID + ".main_hub")));
    }
}
