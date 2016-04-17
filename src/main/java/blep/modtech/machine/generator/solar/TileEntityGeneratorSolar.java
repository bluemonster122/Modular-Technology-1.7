package blep.modtech.machine.generator.solar;

import blep.modtech.machine.generator.TileEntityGeneratorBase;
import blep.modtech.reference.GeneratorConfigurations;
import blep.modtech.util.LogHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumSkyBlock;
import sun.rmi.runtime.Log;

/**
 * Created by Blue <boo122333@gmail.com>.
 */
public class TileEntityGeneratorSolar extends TileEntityGeneratorBase
{

    private TileEntityGeneratorSolar()
    {
        super(GeneratorConfigurations.SOLAR_GENERATOR_MAX_ENERGY, GeneratorConfigurations.SOLAR_GENERATOR_MAX_TRANSFER);
    }

    public static TileEntityGeneratorSolar create()
    {
        return new TileEntityGeneratorSolar();
    }

    @Override
    public void update()
    {
        super.update();
    }

    @Override
    protected boolean shouldAttemptPushing()
    {
        return 0 < energy.getEnergyStored();
    }

    @Override
    public boolean shouldGenerate()
    {
        return true;
    }

    @Override
    public void generate()
    {
        energy.modifyEnergyStored(getGenerateAmount());
    }

    public ITextComponent getDisplayName()
    {
        return new TextComponentString("Solar Generator");
    }

    public int getGenerateAmount()
    {
        return worldObj.canSeeSky(pos.up()) ? (int) (energy.getEnergyStored() == energy.getMaxEnergyStored() ? 0 : 100 * worldObj.getSunBrightnessFactor(1F)) : 0;
    }
}