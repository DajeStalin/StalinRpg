package net.stalin.stalinrpg.item.models3d;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.stalin.stalinrpg.item.ModArmorMaterial;
import net.stalin.stalinrpg.item.models3d.armor.items.VampireLeatherBootsItem;
import net.stalin.stalinrpg.item.models3d.armor.items.VampireLeatherChestItem;
import net.stalin.stalinrpg.item.models3d.armor.items.VampireLeatherHeadItem;
import net.stalin.stalinrpg.item.models3d.armor.items.VampireLeatherLegsItem;
import software.bernie.geckolib3.GeckoLib;

public class ItemRegistry3DArmor {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GeckoLib.ModID);

    public static final RegistryObject<VampireLeatherHeadItem> VAMPIRE_LEATHER_HEAD = ITEMS.register("vampire_leather_head",
            () -> new VampireLeatherHeadItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties()));

    public static final RegistryObject<VampireLeatherChestItem> VAMPIRE_LEATHER_CHEST = ITEMS.register("vampire_leather_chest",
            () -> new VampireLeatherChestItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties()));

    public static final RegistryObject<VampireLeatherLegsItem> VAMPIRE_LEATHER_LEGS = ITEMS.register("vampire_leather_legs",
            () -> new VampireLeatherLegsItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties()));

    public static final RegistryObject<VampireLeatherBootsItem> VAMPIRE_LEATHER_BOOTS = ITEMS.register("vampire_leather_boots",
            () -> new VampireLeatherBootsItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET, new Item.Properties()));
}
