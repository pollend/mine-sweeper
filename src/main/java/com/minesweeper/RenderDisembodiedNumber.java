 package com.minesweeper;

 import org.lwjgl.opengl.GL11;
 
 /*public class RenderDisembodiedNumber
   extends bdm
 {
   public void a(anq var1, double var2, double var4, double var6, float var8)
   {
     if (var1.a(this.b.j, this.b.k, this.b.l) < 500.0D)
     {
       GL11.glPushMatrix();
       GL11.glTranslated(var2 + 0.5D, var4 + 0.5D + ((TileEntityDisembodiedNumber)var1).riseFall, var6 + 0.5D);
       GL11.glScalef(-0.05F, -0.05F, -0.05F);
       GL11.glRotatef(-this.b.h, 0.0F, 1.0F, 0.0F);
       
       b().b(var1.p() + "", 0, 0, 0);
       GL11.glPopMatrix();
     }
   }
   
 
 
 
 
 
 
   public void a(bdl par1TileEntityRenderer)
   {
     this.b = par1TileEntityRenderer;
   }
 }


/* Location:              C:\Users\Michael\Desktop\oldComputer\MinecraftMods\MineSweeper\!\MineSweeper\RenderDisembodiedNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */