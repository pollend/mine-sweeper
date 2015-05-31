/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/


package com.minesweeper.tileEntities;

import com.minesweeper.blocks.BlockExplosiveMine;
import com.minesweeper.blocks.BlockFloatingNumber;

import com.minesweeper.blocks.BlockGoodies;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import java.util.ArrayList;


public class TileEntityMineFieldCompletionSearch
        extends TileEntity {


    protected BlockPos[] goodies = new BlockPos[0];
    protected BlockPos[] explosives = new BlockPos[0];

    //reference tile entities to prevent storing too much data
    private BlockPos reference = new BlockPos(0, 0, 0);

    public TileEntityMineFieldCompletionSearch() {

    }

    /**
     * returns all the explosives in this particular minefield
     * @param world
     * @return
     */
    public BlockPos[] getExplosives(World world) {
        if (this.reference.equals(this.getPos())) {
            return this.explosives;
        } else {
            //make sure the tile entity is not null
            if(world.getTileEntity(reference) != null)
            return ((TileEntityMineFieldCompletionSearch) world.getTileEntity(reference)).explosives;
        }
        return  null;


    }

    /**
     * returns all the good blocks within this field
     * @param world
     * @return
     */
    public BlockPos[] getGoodies(World world) {
        if (this.reference.equals(this.getPos())) {
            return this.goodies;
        } else {
            if(world.getTileEntity(reference) != null)
            return ((TileEntityMineFieldCompletionSearch) world.getTileEntity(reference)).goodies;
        }
        return  null;

    }

    /**
     * prevent blocks from clearing tileEntities
     * @param world
     * @param pos
     * @param oldState
     * @param newSate
     * @return
     */
    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return false;
    }

    public TileEntityMineFieldCompletionSearch(BlockPos refrence, BlockPos[] goodies, BlockPos[] explosives) {
        this.reference = refrence;
        this.goodies = goodies;
        this.explosives = explosives;
    }

    /**
     * test if the minefield has been completed
     * @param world
     * @return
     */
    public boolean isMineFieldCompleted(World world) {
        if (this.reference.equals(this.getPos())) {
            if (this.explosives.length == 0) {
                return false;
            }

            //ignore the first block since the player hasn't destoryed this block
            boolean firstIgnore = false;
            for (int i = 0; i < this.goodies.length; i++) {
                if (((world.getBlockState(goodies[i])).getBlock() instanceof BlockGoodies)) {
                    if(firstIgnore)
                      return false;
                    if (!firstIgnore)
                        firstIgnore = true;
                }
            }
        } else {
            if(world.getTileEntity(reference) != null)
            return ((TileEntityMineFieldCompletionSearch) world.getTileEntity(reference)).isMineFieldCompleted(this.getWorld());
        }
        return true;
    }

    /**
     * loops through all the blocks and clears the field
     * @param world
     */
    public void clearField(World world) {
        if (this.reference.equals(this.getPos())) {
            for (int i = 0; i < this.explosives.length; i++) {
                world.setBlockToAir(explosives[i]);
            }


            for (int i = 0; i < this.goodies.length; i++) {
                world.setBlockToAir(goodies[i]);
            }
        } else {
            ((TileEntityMineFieldCompletionSearch) world.getTileEntity(reference)).clearField(this.getWorld());
        }

    }


    private void writePositionsToNbtTags(NBTTagCompound tagCompound, String key, BlockPos[] pos) {
        int[] lx = new int[pos.length];
        int[] ly = new int[pos.length];
        int[] lz = new int[pos.length];
        for (int i = 0; i < pos.length; i++) {
            lx[i] = pos[i].getX();
            ly[i] = pos[i].getY();
            lz[i] = pos[i].getZ();
        }
        tagCompound.setIntArray(key + "x", lx);
        tagCompound.setIntArray(key + "y", ly);
        tagCompound.setIntArray(key + "z", lz);

    }

    private BlockPos[] readPositionsFromNbtTags(NBTTagCompound tagCompound, String key) {
        int[] lx = tagCompound.getIntArray(key + "x");
        int[] ly = tagCompound.getIntArray(key + "y");
        int[] lz = tagCompound.getIntArray(key + "z");

        BlockPos[] pos = new BlockPos[lx.length];

        for (int i = 0; i < lx.length; i++) {
            pos[i] = new BlockPos(lx[i], ly[i], lz[i]);
        }
        return pos;
    }


    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);

        if (reference.equals(this.getPos())) {

            this.writePositionsToNbtTags(par1NBTTagCompound, "goodies", this.goodies);
            this.writePositionsToNbtTags(par1NBTTagCompound, "explosiveBlocks", this.explosives);
        }

        par1NBTTagCompound.setInteger("refrence_x", reference.getX());
        par1NBTTagCompound.setInteger("refrence_y", reference.getY());
        par1NBTTagCompound.setInteger("refrence_z", reference.getZ());


    }


    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        this.reference = new BlockPos(par1NBTTagCompound.getInteger("refrence_x"), par1NBTTagCompound.getInteger("refrence_y"), par1NBTTagCompound.getInteger("refrence_z"));
        if (reference.equals(this.getPos())) {
            this.goodies = this.readPositionsFromNbtTags(par1NBTTagCompound, "goodies");
            this.explosives = this.readPositionsFromNbtTags(par1NBTTagCompound, "explosiveBlocks");
        }


    }
}

