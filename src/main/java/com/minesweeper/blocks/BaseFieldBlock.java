package com.minesweeper.blocks;

import com.minesweeper.tileEntities.BaseTileFieldEntity;
import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.io.Console;
import java.util.Random;

/**
 * Created by Michael on 5/27/2015.
 */
public class BaseFieldBlock  extends Block{

    public static final PropertyInteger NEIGHBORS = PropertyInteger.create("neighbors", 0, 26);

    protected BaseFieldBlock(Material materialIn) {

        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(NEIGHBORS,Integer.valueOf(1)));
    }
    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {NEIGHBORS});
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(NEIGHBORS,Integer.valueOf(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(NEIGHBORS)).intValue();
    }


    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return  state;
    }

    public  int getStartingCount()
    {
        return  0;
    }

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



    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));;
    }

    @Override
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


    public int numberOfNeighbors(BlockPos pos, World world)
    {
        return  numberOfNeighbors(pos,(IBlockAccess)world);
    }


    public int numberOfNeighbors(BlockPos pos, IBlockAccess world)
    {
        int lmineCount =this.getStartingCount();
        BlockPos[] lsurroundingBlocks = getSurroundingBlocks(pos);
        for(int i =0; i< lsurroundingBlocks.length; i++)
        {
            lmineCount += world.getBlockState(lsurroundingBlocks[i]).getBlock() instanceof BlockExplosiveMine ? 1 : 0;
        }
        return  lmineCount;
    }


    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        int MineCount = getStartingCount();
        MineCount += numberOfNeighbors(pos,world);


     /*   if (MineCount > 14) {
            MineCount = 14;
        }
        if(MineCount < 0)
            world.setBlockToAir(pos);
        else {*/
            world.setBlockState(pos, state.withProperty(NEIGHBORS, Integer.valueOf(MineCount)), 2);
       // ((BaseTileFieldEntity)world.getTileEntity(pos)).neighbors = MineCount;

        //}
            super.onBlockAdded(world, pos, state);
    }


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        int marked = ((Integer)world.getBlockState(pos).getValue(NEIGHBORS)).intValue();
        if(marked > 0) {
            world.setBlockState(pos, state.withProperty(NEIGHBORS, Integer.valueOf(0)));
        }
        else
        this.onBlockAdded(world,pos,state);

        return super.onBlockActivated(world, pos,state,playerIn,side,hitX,hitY,hitZ);
    }

}
