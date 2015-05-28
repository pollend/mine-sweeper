 package com.minesweeper.Render;

 import net.minecraft.client.gui.FontRenderer;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;

import com.minesweeper.tileEntities.TileEntityFloatingNumber;

@SideOnly(Side.CLIENT)
 public class RenderFloatingNumber
   extends TileEntitySpecialRenderer
 {


     @Override
     public void renderTileEntityAt(TileEntity p_180535_1_, double x, double y, double z, float p_180535_8_, int p_180535_9_) {
         TileEntityFloatingNumber tileEntityFloatingNumber = (TileEntityFloatingNumber)p_180535_1_;
        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5D, y + 0.5D + tileEntityFloatingNumber.riseFall, z + 0.5D);
        GlStateManager.scale(-0.05F, -0.05F, -0.05F);

        GlStateManager.rotate(-this.rendererDispatcher.entityYaw, 0.0F, 1.0F, 0.0F);

        FontRenderer fontrenderer = this.getFontRenderer();
        fontrenderer.drawString(""+tileEntityFloatingNumber.getBlockMetadata(), 0, 0, 0);
        GlStateManager.popMatrix();
     }
}
