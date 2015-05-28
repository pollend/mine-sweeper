 package com.minesweeper.blocks;

 import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

import com.minesweeper.tileEntities.TileEntityFloatingNumber;
 public class BlockFloatingNumber  extends BaseFieldBlock
 {
     public final static String name = "floatingNumber";


     public BlockFloatingNumber()
   {
     super(Material.rock);
   }
   /*
   @Override
   public TileEntity createTileEntity(World world, int metadata)
   {
     return new TileEntityFloatingNumber(world);
   }

   @Override
	public boolean hasTileEntity(int metadata)
	{
	 return true;
	}
   @Override
   public boolean renderAsNormalBlock()
   {
       return false;
   }
   
   @Override
   public boolean isOpaqueCube(){
       return false;
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


 /*public boolean isCollidable()
 {
     return false;
 }*/

 /*
   public int d()
   {
     return -1;
   }*/



 }
