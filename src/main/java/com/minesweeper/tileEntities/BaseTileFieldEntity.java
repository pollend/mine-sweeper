package com.minesweeper.tileEntities;

import com.minesweeper.blocks.BaseFieldBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.io.Console;

/**
 * Created by Michael on 5/29/2015.
 */
public class BaseTileFieldEntity extends TileEntity {
    public int neighbors = 0;
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("neighbors", neighbors);
    }


    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        neighbors = par1NBTTagCompound.getInteger("neighbors");
        //this.getWorld().setBlockState(this.getPos(), this.getWorld().getBlockState(this.getPos()).withProperty(BaseFieldBlock.STATES, Integer.valueOf(par1NBTTagCompound.getInteger("neighbors"))));

    }
@Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
        if(oldState.getBlock() instanceof  BaseFieldBlock )
        this.neighbors = ((Integer)oldState.getValue(BaseFieldBlock.NEIGHBORS)).intValue();
        return  false;
    }


}
