/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/

package com.minesweeper.blocks;

 import com.minesweeper.MineSweeper;
 import net.minecraft.block.Block;
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
     public TileEntity createNewTileEntity(World worldIn, int meta) {
         return new TileEntityFloatingNumber();
     }
 }
