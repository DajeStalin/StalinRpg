package net.stalin.stalinrpg.network.networking.skills;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class FireBall {
    private final double x;
    private final double y;
    private final double z;

    public FireBall(PacketBuffer buffer) {
        x = buffer.readDouble();
        y = buffer.readDouble();
        z = buffer.readDouble();
    }

    public FireBall(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void toBytes(PacketBuffer buffer) {
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
    }

    public void FireBallSetPos(Supplier<NetworkEvent.ServerCustomPayloadLoginEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerWorld world = ctx.get().getSender().getLevel();
            FireballEntity ball = EntityType.FIREBALL.create(world);
            ball.setPos(x, y + 1D, z);
            world.addFreshEntity(ball);
        });
        ctx.get().setPacketHandled(true);
    }
}
