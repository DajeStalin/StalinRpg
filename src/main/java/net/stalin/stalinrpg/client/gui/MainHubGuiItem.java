package net.stalin.stalinrpg.client.gui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.stalin.stalinrpg.item.ModGroup;

public class MainHubGuiItem extends Item {
    public MainHubGuiItem() {
        super(new Properties().tab(ModGroup.itemGroup));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (playerIn.level.isClientSide) {
            DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> OpenGUI::new);
        }
        return super.use(worldIn, playerIn, handIn);
    }
}
