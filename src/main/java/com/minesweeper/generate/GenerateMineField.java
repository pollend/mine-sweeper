/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/

package com.minesweeper.generate;
 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.minesweeper.blocks.BaseFieldBlock;
import com.minesweeper.blocks.BlockExplosiveMine;
import com.minesweeper.blocks.BlockGoodies;
import com.minesweeper.blocks.MineSweeperBlocks;
import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

 
 public class GenerateMineField
   implements IWorldGenerator
 {
   private final int CHUNKSIZE = 16;
   
   List<BlockPos> goodieBlock = new ArrayList<BlockPos>();
   List<BlockPos> mineBlock = new ArrayList<BlockPos>();


   @Override
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
     BlockPos fieldLocation = new BlockPos(chunkX * 16 + random.nextInt(16),random.nextInt(20) +15,chunkZ * 16 + random.nextInt(16));
     int size = random.nextInt(40) + 40;
     if (random.nextFloat() * 100.0F > 97.0F)
     {

       this.goodieBlock = new ArrayList<BlockPos>();
       this.mineBlock = new ArrayList<BlockPos>();

       for (int i = size; i > 0; i--) {
         AddMine(fieldLocation.add(random.nextInt(10) - 5,  random.nextInt(10) - 5, random.nextInt(10) - 5), world);
       }

       for(int i =0; i < goodieBlock.size(); i++)
       {
         if(!(world.getBlockState(goodieBlock.get(i)).getBlock() instanceof  BlockGoodies))
         {
           goodieBlock.remove(i);
           i--;
         }

       }

       for(int i =0; i < mineBlock.size(); i++)
       {
         if(!(world.getBlockState(mineBlock.get(i)).getBlock() instanceof  BlockExplosiveMine))
         {
           mineBlock.remove(i);
           i--;
         }

       }

       BlockPos[] lgoodieBlocks = this.goodieBlock.toArray(new BlockPos[0]);
       BlockPos[] lmineBlocks = this.mineBlock.toArray(new BlockPos[0]);
       for (int i = 0; i < lgoodieBlocks.length; i++)
       {
         world.setTileEntity(lgoodieBlocks[i], new TileEntityMineFieldCompletionSearch(lmineBlocks[0],lgoodieBlocks, lmineBlocks));
       }
       for (int i = 0; i < lmineBlocks.length; i++)
       {
         world.setTileEntity(lmineBlocks[i], new TileEntityMineFieldCompletionSearch(lmineBlocks[0],lgoodieBlocks, lmineBlocks));
       }
     }
   }




   public void AddMine(BlockPos pos, World world)
   {
     if (!(world.getBlockState(pos).getBlock() instanceof BlockExplosiveMine))
     {
       world.setBlockState(pos, MineSweeperBlocks.blockExplosiveMine.getDefaultState(),2);
       this.mineBlock.add(pos);

       SetNumberBlock(pos.add(-1, -1, -1), world);
       SetNumberBlock(pos.add(-1, -1, 0), world);
       SetNumberBlock(pos.add(-1, -1, 1), world);

       SetNumberBlock(pos.add(1, -1, -1), world);
       SetNumberBlock(pos.add(1, -1, 0), world);
       SetNumberBlock(pos.add(1, -1, 1), world);

       SetNumberBlock(pos.add(0, -1, -1), world);
       SetNumberBlock(pos.add(0, -1, 0), world);
       SetNumberBlock(pos.add(0, -1, 1), world);


       SetNumberBlock(pos.add(-1, 1, -1), world);
       SetNumberBlock(pos.add(-1, 1, 0), world);
       SetNumberBlock(pos.add(-1, 1, 1), world);

       SetNumberBlock(pos.add(1, 1, -1), world);
       SetNumberBlock(pos.add(1, 1, 0), world);
       SetNumberBlock(pos.add(1, 1, 1), world);

       SetNumberBlock(pos.add(0, 1, -1), world);
       SetNumberBlock(pos.add(0, 1, 0), world);
       SetNumberBlock(pos.add(0, 1, 1), world);


       SetNumberBlock(pos.add(-1, 0, -1), world);
       SetNumberBlock(pos.add(-1, 0, 0), world);
       SetNumberBlock(pos.add(-1, 0, 1), world);

       SetNumberBlock(pos.add(1, 0, -1), world);
       SetNumberBlock(pos.add(1, 0, 0), world);
       SetNumberBlock(pos.add(1, 0, 1), world);

       SetNumberBlock(pos.add(0, 0, -1), world);
       SetNumberBlock(pos.add(0, 0, 1), world);


     }
   }


   public void SetNumberBlock(BlockPos pos, World world)
   {
     if (world.getBlockState(pos).getBlock() instanceof BlockExplosiveMine)
     {

       world.setBlockState(pos, MineSweeperBlocks.blockExplosiveMine.getDefaultState(),2);
     }
     else if(!(world.getBlockState(pos).getBlock() instanceof BlockGoodies) && !(world.getBlockState(pos).getBlock() instanceof BlockExplosiveMine))
     {

       world.setBlockState(pos,  MineSweeperBlocks.blockGoodies.getDefaultState(),2);
      this.goodieBlock.add(pos);
     }

     IBlockState selectedBlock =  world.getBlockState(pos);
     selectedBlock.getBlock().onBlockAdded(world, pos,selectedBlock);

   }


 }
