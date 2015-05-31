/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/

package com.minesweeper.tileEntities;

import com.minesweeper.blocks.BaseFieldBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;

import java.io.Console;

/**
 * Created by Michael on 5/29/2015.
 */
public class BaseTileFieldEntity extends TileEntity {
    public int neighbors = 0;
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        //par1NBTTagCompound.setInteger("neighbors", ((Integer) this.getWorld().getBlockState(this.getPos()).getValue(BaseFieldBlock.STATES)).intValue());
    }


    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
      /*  try {
            this.getWorld().setBlockState(this.getPos(), this.getWorld().getBlockState(this.getPos()).withProperty(BaseFieldBlock.STATES, Integer.valueOf(par1NBTTagCompound.getInteger("neighbors"))));
        }
        catch (NullPointerException e)
        {

        }*/
    }


}
