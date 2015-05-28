 package com.minesweeper.blocks;

 import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
 import net.minecraft.block.properties.PropertyInteger;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.util.BlockPos;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.world.World;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import com.minesweeper.MineSweeper;
 import scala.Int;


 public class BlockExplosiveMine
   extends BaseFieldBlock
 {
     public final static String name = "explosivemine";
	 
	 
   public BlockExplosiveMine()
   {
     super(Material.rock);
       this.setCreativeTab(CreativeTabs.tabBlock);

       this.setUnlocalizedName(MineSweeper.MODID+"_"+name);


       this.setHardness(1.5F);
       this.setResistance(10.0F);
       this.setStepSound(soundTypePiston);
       GameRegistry.registerBlock(this, name);
   }
/*
   @Override
   public void registerBlockIcons(IIconRegister icon)
   {
		numbers = new IIcon[13];


		this.cancle = icon.registerIcon(MineSweeper.MODID + ":" + "cancel");

		for(int x =0; x < numbers.length; x++)
		{
			   numbers[x] = icon.registerIcon(MineSweeper.MODID + ":" + "stone-"+(x+1));
		}
  // blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" + Names.tutBlock_unlocalizedName);

   }

   @Override
   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int side, int metadata) {
	   if(metadata == 15)
		   return cancle;
	   else
		   return  numbers[metadata];

   }*/



   
   /*public boolean a(World par1World, int par2, int par3, int par4, qx par5EntityPlayer, int par6, float par7, float par8, float par9)
   {
     if (par5EntityPlayer.bI.g().b() == uk.D)
     {
 
       if (par1World.getBlockMetadata(par2, par3, par4) == 15) {
         g(par1World, par2, par3, par4);
       } else
         par1World.d(par2, par3, par4, 15);
     }
     return this.cp;
   }*/
   
   /*public void k(World par1World, int par2, int par3, int par4)
   {

     c(par1World, par2, par3, par4, 0);
   }*/

 /*
   public void c(World world, int x, int y, int z, int par5)
   {
     world.b(x - 1,- 1, z - 1, 0);
     world.b(x - 1,- 1, z, 0);
     world.b(x - 1,- 1, z + 1, 0);
     
     world.b(x + 1,- 1, z - 1, 0);
     world.b(x + 1,- 1, z, 0);
     world.b(x + 1,- 1, z + 1, 0);
     
     world.b(x,- 1, z - 1, 0);
     world.b(x,- 1, z, 0);
     world.b(x,- 1, z + 1, 0);
     
 
     world.b(x - 1,+ 1, z - 1, 0);
     world.b(x - 1,+ 1, z, 0);
     world.b(x - 1,+ 1, z + 1, 0);
     
     world.b(x + 1,+ 1, z - 1, 0);
     world.b(x + 1,+ 1, z, 0);
     world.b(x + 1,+ 1, z + 1, 0);
     
     world.b(x,+ 1, z - 1, 0);
     world.b(x,+ 1, z, 0);
     world.b(x,+ 1, z + 1, 0);
     
 
     world.b(x - 1, y, z - 1, 0);
     world.b(x - 1, y, z, 0);
     world.b(x - 1, y, z + 1, 0);
     
     world.b(x + 1, y, z - 1, 0);
     world.b(x + 1, y, z, 0);
     world.b(x + 1, y, z + 1, 0);
     
     world.b(x, y, z - 1, 0);
     world.b(x, y, z + 1, 0);
     
 
     if (!world.J)
     {
 
       world.a((lq)null, x, y, z, 7.0F, true);
     }
   }*/






   public int a(Random par1Random)
   {

     return 0;
   }


   public String getTextureFile()
   {

     return "/MineSweeper/MineSweeperSheet.png";
   }

   public int a(int par1, int par2)
   {

     return par2 - 1;
   }
 }
