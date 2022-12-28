package net.stalin.stalinrpg.eventsubscriber.common;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.init.ModCapability;

@Mod.EventBusSubscriber(modid = StalinRpg.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {
    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        StalinRpg.LOGGER.info("----------------------->ModEventSubscriber.onCommonSetup()");
        ModCapability.register();
    }
}
