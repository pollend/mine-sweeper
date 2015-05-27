 package com.minesweeper;

 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.world.World;


 public class TileEntityMineFieldCompletionSearch
   extends TileEntity
 {
   public int[] xNumberBlocks = new int[0];
   public int[] yNumberBlocks = new int[0];
   public int[] zNumberBlocks = new int[0];
   
   public int[] xExplosiveBlocks = new int[0];
   public int[] yExplosiveBlocks = new int[0];
   public int[] zExplosiveBlocks = new int[0];
   
 
 
   public boolean canUpdate()
   {
     return false;
   }
   
 
 
 
 /*
   public boolean IsMineFieldCompleted(World world)
   {
     if (this.xExplosiveBlocks.length == 0)
     {
       return false;
     }
     for (int i = 0; i < this.xExplosiveBlocks.length; i++)
     {
       if (world.a(this.xExplosiveBlocks[i], this.yExplosiveBlocks[i], this.zExplosiveBlocks[i]) != 701)
       {
         return false;
       }
     }
     int maxAllowedGoodieBlocks = 1;
     for (int i = 0; i < this.xNumberBlocks.length; i++)
     {
       if (world.a(this.xNumberBlocks[i], this.yNumberBlocks[i], this.zNumberBlocks[i]) != 700)
       {
         if (maxAllowedGoodieBlocks <= 0)
           return false;
         maxAllowedGoodieBlocks--;
       }
     }
     return true;
   }
   */
 /*
 
 
   public void ClearField(World world)
   {
     for (int i = 0; i < this.xExplosiveBlocks.length; i++)
     {
       world.e(this.xExplosiveBlocks[i], this.yExplosiveBlocks[i], this.zExplosiveBlocks[i], 0);
     }
     
 
     for (int i = 0; i < this.xNumberBlocks.length; i++)
     {
       world.e(this.xNumberBlocks[i], this.yNumberBlocks[i], this.zNumberBlocks[i], 0);
     }
   }
   
 */
 
 
 
 
   public void writeToNBT(NBTTagCompound par1NBTTagCompound)
   {
     super.writeToNBT(par1NBTTagCompound);
     par1NBTTagCompound.setIntArray("Xg", this.xNumberBlocks);
     par1NBTTagCompound.setIntArray("Yg", this.yNumberBlocks);
     par1NBTTagCompound.setIntArray("Zg", this.zNumberBlocks);
     
     par1NBTTagCompound.setIntArray("Xex", this.xExplosiveBlocks);
     par1NBTTagCompound.setIntArray("Yex", this.yExplosiveBlocks);
     par1NBTTagCompound.setIntArray("Zex", this.zExplosiveBlocks);
   }
   
 
 
 
 
   public void readFromNBT(NBTTagCompound par1NBTTagCompound)
   {
     super.readFromNBT(par1NBTTagCompound);
     this.xNumberBlocks = par1NBTTagCompound.getIntArray("Xg");
     this.yNumberBlocks = par1NBTTagCompound.getIntArray("Yg");
     this.zNumberBlocks = par1NBTTagCompound.getIntArray("Zg");
     
     this.xExplosiveBlocks = par1NBTTagCompound.getIntArray("Xex");
     this.yExplosiveBlocks = par1NBTTagCompound.getIntArray("Yex");
     this.zExplosiveBlocks = par1NBTTagCompound.getIntArray("Zex");
   }
 }


/* Location:              C:\Users\Michael\Desktop\oldComputer\MinecraftMods\MineSweeper\!\MineSweeper\TileEntityMineFieldCompletionSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */