package net.stalin.stalinrpg.test.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.stalin.stalinrpg.item.ModArmorMaterial;
import software.bernie.geckolib3.GeckoLib;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GeckoLib.ModID);

    public static final RegistryObject<GeckoTestArmorItem> TEST_HEAD = ITEMS.register("test_head",
            () -> new GeckoTestArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties()));
    public static final RegistryObject<GeckoTestArmorItem> TEST_CHEST = ITEMS.register("test_chest",
            () -> new GeckoTestArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties()));
    public static final RegistryObject<GeckoTestArmorItem> TEST_LEGGINGS = ITEMS.register("test_leggings",
            () -> new GeckoTestArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties()));
    public static final RegistryObject<GeckoTestArmorItem> TEST_BOOTS = ITEMS.register("test_boots",
            () -> new GeckoTestArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET, new Item.Properties()));
}
