package net.stalin.stalinrpg.network.networking.skills;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.capability.IGenericCapability;
import net.stalin.stalinrpg.capability.experiance.IBaseExperienceCapability;
import net.stalin.stalinrpg.capability.experiance.PlayerExperienceCapabilityProvider;

import java.util.function.Supplier;

public class LightningBolt {
    private final double x;
    private final double y;
    private final double z;

    public LightningBolt(PacketBuffer buffer) {
        x = buffer.readDouble();
        y = buffer.readDouble();
        z = buffer.readDouble();
    }

    public LightningBolt(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void toBytes(PacketBuffer buffer) {
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
    }

    public void LightningBoltSetPos(Supplier<NetworkEvent.ServerCustomPayloadLoginEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerWorld world = ctx.get().getSender().getLevel();
            LightningBoltEntity LightningBolt = EntityType.LIGHTNING_BOLT.create(world);
            LightningBolt.setPos(x, y, z);
            world.addFreshEntity(LightningBolt);
        });
        ctx.get().setPacketHandled(true);
    }
}
