 package com.minesweeper;

 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.creativetab.CreativeTabs;
 import net.minecraft.world.World;

 import java.util.Random;

 public class BlockExplosiveMine
   extends Block
 {
   public BlockExplosiveMine()
   {
     super(Material.rock);
       this.setCreativeTab(CreativeTabs.tabBlock);
       this.setBlockName("explosive");
       this.setBlockTextureName(MineSweeper.MODID + ":" + "cancel");
     //super.c(1.5F);
     //super.b(10.0F);
   }



   @Override
   public void onBlockAdded(World world, int x, int y, int z) {

       int MineCount = 1;


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
         world.setBlockToAir(x, y, z);
       } else {
         world.setBlockMetadataWithNotify(x, y, z, MineCount, 2);
       }

   }




   private int IsMineBlock(int x, int y, int z, World world)
   {

     return world.getBlock(x, y, z).getClass() == BlockExplosiveMine.class ? 1 : 0;
   }
   
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
     world.b(x - 1, y - 1, z - 1, 0);
     world.b(x - 1, y - 1, z, 0);
     world.b(x - 1, y - 1, z + 1, 0);
     
     world.b(x + 1, y - 1, z - 1, 0);
     world.b(x + 1, y - 1, z, 0);
     world.b(x + 1, y - 1, z + 1, 0);
     
     world.b(x, y - 1, z - 1, 0);
     world.b(x, y - 1, z, 0);
     world.b(x, y - 1, z + 1, 0);
     
 
     world.b(x - 1, y + 1, z - 1, 0);
     world.b(x - 1, y + 1, z, 0);
     world.b(x - 1, y + 1, z + 1, 0);
     
     world.b(x + 1, y + 1, z - 1, 0);
     world.b(x + 1, y + 1, z, 0);
     world.b(x + 1, y + 1, z + 1, 0);
     
     world.b(x, y + 1, z - 1, 0);
     world.b(x, y + 1, z, 0);
     world.b(x, y + 1, z + 1, 0);
     
 
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
