package net.stalin.stalinrpg.network.networking.skills;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.Explosion;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class Explode {
    private final double x;
    private final double y;
    private final double z;

    public Explode(PacketBuffer buffer) {
        x = buffer.readDouble();
        y = buffer.readDouble();
        z = buffer.readDouble();
    }

    public Explode(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void toBytes(PacketBuffer buffer) {
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
    }

    public void ExplodeCreate(Supplier<NetworkEvent.ServerCustomPayloadLoginEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerWorld world = ctx.get().getSender().getLevel();
            world.explode((Entity)null, x, y + 3D, z, 10F, Explosion.Mode.NONE);
        });
        ctx.get().setPacketHandled(true);
    }
}
