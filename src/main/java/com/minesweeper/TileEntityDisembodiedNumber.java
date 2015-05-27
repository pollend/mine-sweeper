 package com.minesweeper;
 

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


 public class TileEntityDisembodiedNumber
   extends TileEntity
 {
   float riseFall = 0.0F;
   float circle = 0.0F;
   
   public TileEntityDisembodiedNumber()
   {
     this.circle = ((float)(Math.random() * 3.14D * 2.0D));
   }
   
   @SideOnly(Side.CLIENT)
   public void g()
   {
     this.circle = ((float)(this.circle + 0.1D));
     this.riseFall = ((float)Math.sin(this.circle) * 0.09F);
     if (this.circle > 6.28D)
     {
       this.circle = 0.0F;
     }
   }
 }


/* Location:              C:\Users\Michael\Desktop\oldComputer\MinecraftMods\MineSweeper\!\MineSweeper\TileEntityDisembodiedNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */