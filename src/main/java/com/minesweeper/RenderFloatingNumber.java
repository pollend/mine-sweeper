 package com.minesweeper;

 import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import org.lwjgl.opengl.GL11;

import com.minesweeper.tileEntities.TileEntityFloatingNumber;

@SideOnly(Side.CLIENT)
 public class RenderFloatingNumber
   extends TileEntitySpecialRenderer
 {


     @Override
     public void renderTileEntityAt(TileEntity p_180535_1_, double posX, double posZ, double p_180535_6_, float p_180535_8_, int p_180535_9_) {
         TileEntityFloatingNumber tileEntityFloatingNumber = (TileEntityFloatingNumber)p_180535_1_;

         GL11.glPushMatrix();
         GL11.glTranslated(posX + 0.5D, posZ + 0.5D +tileEntityFloatingNumber.riseFall, p_180535_6_ + 0.5D);
         GL11.glScalef(-0.05F, -0.05F, -0.05F);

         EntityPlayer entityplayer = p_180535_1_.getWorld().getClosestPlayer((double) ((float) posX + 0.5F), (double) ((float) p_180535_6_ + 0.5F), (double) ((float) p_180535_6_ + 0.5F), 3.0D);

         GL11.glRotatef(-entityplayer.rotationYaw, 0.0F, 1.0F, 0.0F);

         FontRenderer fontrenderer = this.getFontRenderer();
         fontrenderer.drawString(""+p_180535_1_.getBlockMetadata(), 0, 0, 0, false);
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