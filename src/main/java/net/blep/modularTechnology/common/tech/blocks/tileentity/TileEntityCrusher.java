package net.blep.modularTechnology.common.tech.blocks.tileentity;

import net.blep.modularTechnology.common.core.energy.EnergyNetwork;
import net.blep.modularTechnology.common.core.energy.EnumPowerStatus;
import net.blep.modularTechnology.common.core.energy.IEnergyReciever;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 * @author TheEpicTekkit
 */
public class TileEntityCrusher extends TileEntityMachineBase implements IEnergyReciever
{
    public ItemStack[] slots = new ItemStack[5];
    public boolean[] canShiftClick = {true, true, false, false, false};

    private double energyCapacity = 20000;
    private double energyStored = energyCapacity;
    private double energyRecieveRate = 200;

    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        if (side == 1)
            return new int[]{0, 1};
        else if (side == 0)
            return new int[]{2, 3, 4};
        else
            return new int[]{0};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side)
    {
        if (side != 0)
            if (slot == 0 || slot == 1)
                //TODO: add recipe check
                return true;
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack item, int side)
    {
        if (side != 0)
            return false;
        else if (slot == 2 || slot == 3 || slot == 4)
            return true;
        return false;
    }

    @Override
    public int getSizeInventory()
    {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return slots[slot];
    }

    public ItemStack decrStackSize(int slot, int amount)
    {
        if (slots[slot] != null)
        {
            ItemStack stack;
            if (slots[slot].stackSize <= amount)
            {
                stack = slots[slot];
                slots[slot] = null;
                return stack;
            }
            else
            {
                stack = slots[slot].splitStack(amount);
                if (slots[slot].stackSize == 0)
                {
                    slots[slot] = null;
                }
                return stack;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        slots[slot] = stack;
    }

    @Override
    public String getInventoryName()
    {
        return "container.crusher.name";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return StatCollector.canTranslate(getInventoryName());
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty()
    {

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory()
    {

    }

    @Override
    public void closeInventory()
    {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        return canShiftClick[slot]; //TODO: check if stack is an ore or a battery
    }

    @Override
    public double getEnergyCapacity()
    {
        return energyCapacity;
    }

    @Override
    public double getEnergyStored()
    {
        return energyStored;
    }

    @Override
    public double getEnergyRecieveRate()
    {
        return energyRecieveRate;
    }

    @Override
    public double requestEnergy(double amount)
    {
        return 0;
    }

    @Override
    public EnergyNetwork getEnergyNetwork()
    {
        return null;
    }

    @Override
    public EnumPowerStatus getPowerStatus()
    {
        return null;
    }

    @Override
    public int getMachineProgress()
    {
        return machineProgress;
    }

    @Override
    public boolean getEnergyDirection()
    {
        return energyDirection;
    }
}