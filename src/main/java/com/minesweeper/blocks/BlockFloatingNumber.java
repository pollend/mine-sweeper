 package com.minesweeper.blocks;

 import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

import com.minesweeper.tileEntities.TileEntityDisembodiedNumber;
 public class BlockFloatingNumber extends Block
 {
   public BlockFloatingNumber()
   {
     super(Material.rock);
   }
   
   @Override
   public TileEntity createTileEntity(World world, int metadata)
   {
     return new TileEntityDisembodiedNumber();
   }


public boolean hasTileEntity(int metadata)
{
 return true;
}


/*
public boolean a_(yf par1IBlockAccess, int par2, int par3, int par4, int par5)
{
 return false;
}
   
 
 
public boolean a(int par1, boolean par2)
{
 return false;
}*/


 public boolean isCollidable()
 {
     return false;
 }

 /*
   public int d()
   {
     return -1;
   }*/

     @Override
     public void onBlockAdded(World world, int x, int y, int z){
     int MineCount = 0;

     MineCount += IsMineBlock(x - 1, y - 1, z - 1, world);
     MineCount += IsMineBlock(x - 1, y - 1, z, world);
     MineCount += IsMineBlock(x - 1, y - 1, z + 1, world);
     
     MineCount += IsMineBlock(x + 1, y - 1, z - 1, world);
     MineCount += IsMineBlock(x + 1, y - 1, z, world);
     MineCount += IsMineBlock(x + 1, y - 1, z + 1, world);
     
     MineCount += IsMineBlock(x, y - 1, z - 1, world);
     MineCount += IsMineBlock(x, y - 1, z, world);
     MineCount += IsMineBlock(x, y - 1, z + 1, world);
     
 
     MineCount += IsMineBlock(x - 1, y + 1, z - 1, world);
     MineCount += IsMineBlock(x - 1, y + 1, z, world);
     MineCount += IsMineBlock(x - 1, y + 1, z + 1, world);
     
     MineCount += IsMineBlock(x + 1, y + 1, z - 1, world);
     MineCount += IsMineBlock(x + 1, y + 1, z, world);
     MineCount += IsMineBlock(x + 1, y + 1, z + 1, world);
     
     MineCount += IsMineBlock(x, y + 1, z - 1, world);
     MineCount += IsMineBlock(x, y + 1, z, world);
     MineCount += IsMineBlock(x, y + 1, z + 1, world);
     
 
     MineCount += IsMineBlock(x - 1, y, z - 1, world);
     MineCount += IsMineBlock(x - 1, y, z, world);
     MineCount += IsMineBlock(x - 1, y, z + 1, world);
     
     MineCount += IsMineBlock(x + 1, y, z - 1, world);
     MineCount += IsMineBlock(x + 1, y, z, world);
     MineCount += IsMineBlock(x + 1, y, z + 1, world);
     
     MineCount += IsMineBlock(x, y, z - 1, world);
     MineCount += IsMineBlock(x, y, z + 1, world);
     
 
     if (MineCount > 14) {
       MineCount = 14;
     }
     
     
     if (MineCount == 0) {
       world.setBlockToAir(x,y,z);
     } else {
         world.setBlockMetadataWithNotify(x,y,z,MineCount,MineCount);
       //world.c(x, y, z, MineCount);
     }
   }

   private int IsMineBlock(int x, int y, int z, World world)
   {
     return world.getBlock(x, y, z).getClass() == BlockExplosiveMine.class ? 1 : 0;
   }

 
   public int a(Random par1Random)
   {
     return 0;
   }

 }
