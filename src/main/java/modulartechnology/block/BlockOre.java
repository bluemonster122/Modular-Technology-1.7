package modulartechnology.block;

import com.blep.modularTechnology.core.client.ClientProxy;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public class BlockOre extends ModBlock
{
//    public final EnumMetalMaterial material;
//
//    public BlockOre(EnumMetalMaterial material)
//    {
//        super(Material.rock, "ore" + material.getName(), "oreBase", material.getOreResistance(), material.getOreHardness(), "pickaxe", material.getMiningLevel(), getModTabs().tabMetals);
//        this.material = material;
//        setGetIcon(false);
//    }
//
//    @SideOnly(Side.CLIENT)
//    public void registerBlockIcons(IIconRegister iconRegister)
//    {
//        blockIcon = iconRegister.registerIcon(ModularTechnology.RESOURCE_PREFIX + "oreBlockBase");
//    }
//
//    public int getRenderType()
//    {
//        return ClientProxy.renderID_ColouredBlock;
//    }
//
//    public int colorMultiplier(IBlockAccess world, int x, int y, int z)
//    {
//        int r = 0;
//        int g = 0;
//        int b = 0;
//
//        if (world.getBlock(x, y, z) instanceof BlockOre)
//        {
//            r = (int) (material.getColour().getX() * 255);
//            g = (int) (material.getColour().getY() * 255);
//            b = (int) (material.getColour().getZ() * 255);
//        }
//
//        return ((r & 0x0ff) << 16) | ((g & 0x0ff) << 8) | (b & 0x0ff);
//    }
}