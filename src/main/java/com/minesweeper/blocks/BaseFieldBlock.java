/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/

package com.minesweeper.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

/**
 * the base minefield block
 */
public class BaseFieldBlock  extends Block{

    public static final PropertyInteger STATES = PropertyInteger.create("states", 0, 15);

    /**
     * create basem minefield block that the rest inherit
     * @param materialIn
     */
    protected BaseFieldBlock(Material materialIn) {

        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(STATES,Integer.valueOf(0)));
    }

    /**
     * create the block state
     * @return
     */
    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, STATES);
    }

    /**
     * get the state from the meta
     * @param meta
     * @return
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(STATES, Integer.valueOf(meta));
    }

    /**
     * get the meta value for the state
     * @param state
     * @return
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(STATES)).intValue();
    }

    /**
     * mines do not drop themselves
     * @param explosionIn
     * @return
     */
    @Override
    public boolean canDropFromExplosion(Explosion explosionIn)
    {
        return false;
    }


    /**
     * no items are dropped when a minefield block is destroyed
     * @param worldIn
     * @param pos
     * @param state
     * @param chance
     * @param fortune
     */
    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {

    }


    public  int getStartingCount()
    {
        return  0;
    }

    /**
     * the surrounding blocks
     * @param pos
     * @return
     */
    public BlockPos[] getSurroundingBlocks(BlockPos pos)
    {
        return  new BlockPos[]{
                pos.add(-1, -1, -1),
                pos.add(-1, -1, 0), 
                pos.add(-1, -1, 1), 
                pos.add(1, -1, -1),
                pos.add(1, -1, 0), 
                pos.add(1, -1, 1), 
                pos.add(0, -1, -1),
                pos.add(0, -1, 0), 
                pos.add(0, -1, 1), 
                pos.add(-1, 1, -1),
                pos.add(-1, 1, 0), 
                pos.add(-1, 1, 1), 
                pos.add(1, 1, -1),
                pos.add(1, 1, 0), 
                pos.add(1, 1, 1), 
                pos.add(0, 1, -1),
                pos.add(0, 1, 0), 
                pos.add(0, 1, 1), 
                pos.add(-1, 0, -1),
                pos.add(-1, 0, 0), 
                pos.add(-1, 0, 1), 
                pos.add(1, 0, -1),
                pos.add(1, 0, 0), 
                pos.add(1, 0, 1), 
                pos.add(0, 0, -1),
                pos.add(0, 0, 1)
        };
    }


    /**
     * tells if this block has mines in a 3X3X3 vicinity
     * @param pos
     * @param world
     * @return
     */
    public  boolean hasMineNeighbor(BlockPos pos,World world)
    {
        BlockPos[] lsurroundingBlocks = getSurroundingBlocks(pos);
        for(int i =0; i< lsurroundingBlocks.length; i++)
        {
            if(world.getBlockState(lsurroundingBlocks[i]).getBlock() instanceof BlockExplosiveMine )
            {
            return  true;}
        }
        return  false;
    }

    /**
     * schedule an update the block after the neighbor changes
     * @param worldIn
     * @param pos
     * @param state
     * @param neighborBlock
     */
    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    }

    @Override
    /**
     * replace all the floating numbers when they are covered over with another block
     */
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        BlockPos[] lsurroundingBlocks = getSurroundingBlocks(pos);
        for (int i = 0; i < lsurroundingBlocks.length; i++) {
            if (worldIn.getBlockState(lsurroundingBlocks[i]).getBlock() instanceof  BlockAir) {
                if(this.numberOfNeighbors(lsurroundingBlocks[i],worldIn) > 0) {
                    worldIn.setBlockState(lsurroundingBlocks[i], MineSweeperBlocks.blockFloatingNumber.getDefaultState(), 2);
                    worldIn.getTileEntity(lsurroundingBlocks[i]).invalidate();
                }
            }
        }
    }


    /**
     * get the number of neighbors surrounding a block
     * @param pos
     * @param world
     * @return
     */
    public int numberOfNeighbors(BlockPos pos, World world)
    {
        int lmineCount =0;
        BlockPos[] lsurroundingBlocks = getSurroundingBlocks(pos);
        for(int i =0; i< lsurroundingBlocks.length; i++)
        {
            lmineCount += world.getBlockState(lsurroundingBlocks[i]).getBlock() instanceof BlockExplosiveMine ? 1 : 0;
        }
        return  lmineCount;
    }


    @Override
    /**
     * will set the initial block number for the onBlock added call
     */
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        int MineCount = getStartingCount();
        MineCount += numberOfNeighbors(pos,world);


        if (MineCount > 14) {
            MineCount = 14;
        }
        if(MineCount < 0)
            world.setBlockToAir(pos);
        else {
            world.setBlockState(pos, state.withProperty(STATES, Integer.valueOf(MineCount)), 2);
        }
            super.onBlockAdded(world, pos, state);
    }


    @Override
    /**
     * switches the block to a marked state when right clicked
     */
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        int marked = ((Integer)world.getBlockState(pos).getValue(STATES)).intValue();
        if (marked == 15) {
            this.onBlockAdded(world,pos,state);
        } else {
            world.setBlockState(pos,state.withProperty(STATES,Integer.valueOf(15)));
        }

        return super.onBlockActivated(world, pos,state,playerIn,side,hitX,hitY,hitZ);
    }

}
