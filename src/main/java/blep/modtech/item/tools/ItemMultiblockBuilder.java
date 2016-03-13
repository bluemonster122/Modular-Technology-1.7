package blep.modtech.item.tools;

import blep.modtech.item.ItemMod;
import blep.modtech.multiblock.MultiblockPattern;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Blue <boo122333@gmail.com>.
 */
public class ItemMultiblockBuilder extends ItemMod
{
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        MultiblockPattern.treefarm.create(worldIn, pos.add(0, 1, 0));
        return true;
    }
}
