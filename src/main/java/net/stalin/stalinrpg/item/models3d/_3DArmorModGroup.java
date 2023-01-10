package net.stalin.stalinrpg.item.models3d;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.stalin.stalinrpg.test.armor.ItemRegistry;

public class _3DArmorModGroup {
    public static final ItemGroup ARMOR_3D = new ItemGroup("3D Armor") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.TEST_HEAD.get());
        }
    };
}
