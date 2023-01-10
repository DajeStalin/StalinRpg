package net.stalin.stalinrpg.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroup {
//    public static final ItemGroup itemGroup = new ObsidianGroup();

    public static final ItemGroup STALINRPG = new ItemGroup("Stalinising") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.AMETHYST.get());
        }
    };
}
