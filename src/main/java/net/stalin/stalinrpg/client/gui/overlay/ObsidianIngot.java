package net.stalin.stalinrpg.client.gui.overlay;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class ObsidianIngot extends Item {
    public ObsidianIngot() {
        super(new Properties().tab(ItemGroup.TAB_MATERIALS));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (playerIn.level.isClientSide) {
            File file = new File("test" + File.separator + "test.txt");
            try {
                FileUtils.writeStringToFile(file, "test", Charset.defaultCharset());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.use(worldIn, playerIn, handIn);
    }
}
