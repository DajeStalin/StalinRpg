package net.stalin.stalinrpg.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.network.handler.PlayerExperienceClientServerHandler;

public class ModNetwork {

    private static final String NETWORK_PROTOCOL_VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(StalinRpg.MOD_ID, "main"),
            () -> NETWORK_PROTOCOL_VERSION,
            NETWORK_PROTOCOL_VERSION::equals,
            NETWORK_PROTOCOL_VERSION::equals
    );

    public static void register() {
        int networkId = 0;
        CHANNEL.registerMessage(networkId++,
                PlayerExperienceClientServerHandler.class,
                PlayerExperienceClientServerHandler::encode,
                PlayerExperienceClientServerHandler::decode,
                PlayerExperienceClientServerHandler::onMessage);
    }
}
