package net.stalin.stalinrpg.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.stalin.stalinrpg.capability.IGenericCapability;

import java.util.function.BiConsumer;

public class EventUtils {
    @SuppressWarnings("unchecked")
    public static <T extends PlayerEntity,U extends LazyOptional<V>, V extends IGenericCapability> void onJoin(T player, BiConsumer<T,U> typedFunctionToExcecute, Capability<V> cap) {
        Minecraft mainThread = Minecraft.getInstance();
        if (player != null && !player.level.isClientSide) {
            U capabilityInstance = (U) player.getCapability(cap);
            mainThread.tell(()-> typedFunctionToExcecute.accept(player, capabilityInstance));
        }
    }
}
