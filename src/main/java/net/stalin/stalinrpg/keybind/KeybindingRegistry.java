package net.stalin.stalinrpg.keybind;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeybindingRegistry {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ClientRegistry.registerKeyBinding(KeyBoardInput.OPEN_GUI_KEY));
        event.enqueueWork(() -> ClientRegistry.registerKeyBinding(KeyBoardInput.LIGHTNING_BOLD_KEY));
        event.enqueueWork(() -> ClientRegistry.registerKeyBinding(KeyBoardInput.FIREBALL_KEY));
        event.enqueueWork(() -> ClientRegistry.registerKeyBinding(KeyBoardInput.EXPLODE_KEY));
    }
}

