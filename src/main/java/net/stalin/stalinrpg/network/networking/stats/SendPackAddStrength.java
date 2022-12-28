package net.stalin.stalinrpg.network.networking.stats;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.capability.IGenericCapability;
import net.stalin.stalinrpg.capability.experiance.IBaseExperienceCapability;
import net.stalin.stalinrpg.capability.experiance.PlayerExperienceCapabilityProvider;
import net.stalin.stalinrpg.client.gui.guiscreens.UpgradeStatsGui;
import net.stalin.stalinrpg.network.networking.Networking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;
import java.util.function.Supplier;

import static net.stalin.stalinrpg.StalinRpg.MOD_ID;

public class SendPackAddStrength {
    private final float maxHealth;
    private final float addHealth;
    UUID UUID;
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public SendPackAddStrength(PacketBuffer buffer) {
        maxHealth = buffer.readFloat();
        addHealth = buffer.readFloat();
        UUID = buffer.readUUID();
    }

    public SendPackAddStrength(float maxHealth, float addHealth, UUID UUID) {
        this.maxHealth = maxHealth;
        this.addHealth = addHealth;
        this.UUID = UUID;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeFloat(this.maxHealth);
        buf.writeFloat(this.addHealth);
        buf.writeUUID(this.UUID);
    }

    public void addStrengthHandler(Supplier<NetworkEvent.ServerCustomPayloadLoginEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            IBaseExperienceCapability expCap = IGenericCapability.getUnwrappedCapability(player,
                    PlayerExperienceCapabilityProvider.LEVEL_CAP);
            expCap.setMaxHealth(addHealth, maxHealth, player);
        });
        ctx.get().setPacketHandled(true);
    }
}
