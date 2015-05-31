/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/

package com.minesweeper.blocks;

 import com.minesweeper.MineSweeper;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockAir;
 import net.minecraft.block.ITileEntityProvider;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.AxisAlignedBB;
 import net.minecraft.util.BlockPos;
 import net.minecraft.world.World;

import java.util.Random;

import com.minesweeper.tileEntities.TileEntityFloatingNumber;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 import scala.Int;

public class BlockFloatingNumber  extends BaseFieldBlock implements ITileEntityProvider
 {
     public final static String name = "floatingNumber";


        public BlockFloatingNumber()
        {
              super(Material.air);
            this.setUnlocalizedName(MineSweeper.MODID+"_"+name);

            GameRegistry.registerBlock(this, name);
        }
     @Override
     public int getRenderType()
     {
         return -1;
     }


     @Override
    public boolean isOpaqueCube(){
        return false;
    }

     @Override
     public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid)
     {
         return false;
     }

     @Override
     public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
     {
         return null;
     }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        updateFloatingNumber(world,pos,state);
    }

     @Override
     public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
     }

     public  void updateFloatingNumber(World world,BlockPos pos,IBlockState state)
     {
         BlockPos[] lsurroundingBlocks = getSurroundingBlocks(pos);
         int lmineCount = 0;
         int lcovered = 0;
         for (int i = 0; i < lsurroundingBlocks.length; i++) {
             if (world.getBlockState(lsurroundingBlocks[i]).getBlock() instanceof  BaseFieldBlock) {

                 if (((Integer) world.getBlockState(lsurroundingBlocks[i]).getValue(STATES)).intValue() == 15) {
                     lcovered++;
                 }
             }
             if (world.getBlockState(lsurroundingBlocks[i]).getBlock() instanceof  BlockExplosiveMine) {

                     lmineCount++;
             }
         }
         if(lcovered == lmineCount) {
             world.setBlockState(pos, state.withProperty(STATES, Integer.valueOf(0)));
         }
         else {
             world.setBlockState(pos, state.withProperty(STATES, Integer.valueOf(lmineCount)));
         }
     }

     @Override
     public TileEntity createNewTileEntity(World worldIn, int meta) {
         return new TileEntityFloatingNumber();
     }
 }
