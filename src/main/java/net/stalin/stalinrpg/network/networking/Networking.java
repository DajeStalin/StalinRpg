package net.stalin.stalinrpg.network.networking;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.network.networking.skills.Explode;
import net.stalin.stalinrpg.network.networking.skills.FireBall;
import net.stalin.stalinrpg.network.networking.skills.LightningBolt;
import net.stalin.stalinrpg.network.networking.stats.SendPackAddStrength;

public class Networking {
    public static SimpleChannel INSTANCE;
    public static final String VERSION = "1.0";
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(StalinRpg.MOD_ID, "first_networking"),
                () -> VERSION,
                (version) -> version.equals(VERSION),
                (version) -> version.equals(VERSION)
        );
        INSTANCE.messageBuilder(SendPackAddStrength.class, nextID())
                .encoder(SendPackAddStrength::toBytes)
                .decoder(SendPackAddStrength::new)
                .consumer(SendPackAddStrength::addStrengthHandler)
                .add();
        INSTANCE.messageBuilder(LightningBolt.class, nextID())
                .encoder(LightningBolt::toBytes)
                .decoder(LightningBolt::new)
                .consumer(LightningBolt::LightningBoltSetPos)
                .add();
        INSTANCE.messageBuilder(FireBall.class, nextID())
                .encoder(FireBall::toBytes)
                .decoder(FireBall::new)
                .consumer(FireBall::FireBallSetPos)
                .add();
        INSTANCE.messageBuilder(Explode.class, nextID())
                .encoder(Explode::toBytes)
                .decoder(Explode::new)
                .consumer(Explode::ExplodeCreate)
                .add();
    }
}
