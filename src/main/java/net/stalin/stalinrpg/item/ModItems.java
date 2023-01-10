package net.stalin.stalinrpg.item;

import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.stalin.stalinrpg.StalinRpg;
import net.stalin.stalinrpg.network.networking.TestMessage;
import net.stalin.stalinrpg.test.TestSkill1;
import net.stalin.stalinrpg.test.TestSkill2;
import software.bernie.geckolib3.item.GeoArmorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StalinRpg.MOD_ID);

    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
            () -> new Item(new Item.Properties().tab(ModGroup.STALINRPG)));


    public static final RegistryObject<Item> obsidianIngot2 = ITEMS.register("obsidian_test_network",
            TestMessage::new);

    public static final RegistryObject<Item> test_skill1 = ITEMS.register("test_skill1",
            TestSkill1::new);

    public static final RegistryObject<Item> test_skill2 = ITEMS.register("test_skill2",
            TestSkill2::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
