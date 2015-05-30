 package com.minesweeper.tileEntities;
 

import com.minesweeper.blocks.BaseFieldBlock;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


 public class TileEntityFloatingNumber
   extends BaseTileFieldEntity implements IUpdatePlayerListBox
 {
   public float riseFall = 0.0F;
   private float circle = 0.0F;
   public World world;

   public static final String name = "tileEntityFloatingNumber";

   public TileEntityFloatingNumber() {
     this.circle = ((float)(Math.random() * 3.14D * 2.0D));

   }

   public  int getNeighbors()
   {
     IBlockState state=   this.worldObj.getBlockState(this.getPos());
     if(state.getBlock() instanceof  BaseFieldBlock)
       return  ((Integer)state.getValue(BaseFieldBlock.NEIGHBORS)).intValue();
   return  0;
   }

   @SideOnly(Side.CLIENT)
   @Override
   public double getMaxRenderDistanceSquared()
   {
     return 100.0D;
   }


   @Override
   public void update() {
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