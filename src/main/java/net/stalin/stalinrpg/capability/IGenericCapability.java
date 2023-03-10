package net.stalin.stalinrpg.capability;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

public interface IGenericCapability {
    public CompoundNBT getNBTData();

    public void setNBTData(CompoundNBT nbt);

    @SuppressWarnings("unchecked")
    public static <T extends PlayerEntity, U extends LazyOptional<V>, V extends IGenericCapability> V getUnwrappedCapability(
            T player, Capability<V> cap) {
        U capabilityInstance = (U) player.getCapability(cap);
        return capabilityInstance.isPresent() ? capabilityInstance.map(x -> x).get() : cap.getDefaultInstance();
    }
}
