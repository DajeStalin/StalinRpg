package net.stalin.stalinrpg.client.gui;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.network.networking.TestMessage;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StalinRpg.MOD_ID);
    public static final RegistryObject<Item> obsidianIngot = ITEMS.register("gui_tem", MainHubGuiItem::new);
    public static final RegistryObject<Item> obsidianIngot2 = ITEMS.register("obsidian_test_network", TestMessage::new);
}
