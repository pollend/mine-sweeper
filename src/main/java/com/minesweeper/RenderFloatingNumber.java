 package com.minesweeper;

 import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.minesweeper.tileEntities.TileEntityFloatingNumber;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
@SideOnly(Side.CLIENT)
 public class RenderFloatingNumber
   extends TileEntitySpecialRenderer
 {
	 
	 @Override
	 public void renderTileEntityAt(TileEntity tileEntity, double x,double y, double z, float f) {
		 TileEntityFloatingNumber tileEntityFloatingNumber = (TileEntityFloatingNumber)tileEntity;
		 
	       GL11.glPushMatrix();
	       GL11.glTranslated(x + 0.5D, y + 0.5D +tileEntityFloatingNumber.riseFall, z + 0.5D);
	       GL11.glScalef(-0.05F, -0.05F, -0.05F);
	      
	       EntityPlayer entityplayer = tileEntity.getWorldObj().getClosestPlayer((double)((float)x+ 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), 3.0D);

	       GL11.glRotatef(-entityplayer.rotationYaw, 0.0F, 1.0F, 0.0F);
	       
	       FontRenderer fontrenderer = this.func_147498_b();
	       fontrenderer.drawString(""+tileEntity.getBlockMetadata(), 0, 0, 0, false);
	      // b().b(var1.p() + "", 0, 0, 0);
	       GL11.glPopMatrix();

	 }
  /* public void a(bdl par1TileEntityRenderer)
   {
     this.b = par1TileEntityRenderer;
   }*/
}


/* Location:              C:\Users\Michael\Desktop\oldComputer\MinecraftMods\MineSweeper\!\MineSweeper\RenderDisembodiedNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */