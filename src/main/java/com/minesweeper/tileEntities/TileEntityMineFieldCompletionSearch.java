 package com.minesweeper.tileEntities;

 import com.minesweeper.blocks.BlockExplosiveMine;
import com.minesweeper.blocks.BlockFloatingNumber;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.BlockPos;
 import net.minecraft.world.World;


 public class TileEntityMineFieldCompletionSearch
   extends TileEntity
 {
   public BlockPos[] goodies =new BlockPos[0];
   public BlockPos[] explosives =new BlockPos[0];

   public  TileEntityMineFieldCompletionSearch()
   {

   }

 public TileEntityMineFieldCompletionSearch(BlockPos[] goodies, BlockPos[] explosives)
 {
   this.goodies = goodies;
   this.explosives = explosives;
 }

   public boolean IsMineFieldCompleted(World world)
   {
     if (this.explosives.length == 0)
     {
       return false;
     }
     for (int i = 0; i < this.explosives.length; i++)
     {
       if (!(world.getBlockState(explosives[i]).getBlock() instanceof BlockExplosiveMine))
       {
         return false;
       }
     }
     for (int i = 0; i < this.goodies.length; i++)
     {
       if (!((world.getBlockState(goodies[i])).getBlock() instanceof BlockFloatingNumber))
       {
           return false;
       }
     }
     return true;
   }
 
   public void ClearField(World world)
   {
     for (int i = 0; i < this.explosives.length; i++)
     {
       world.setBlockToAir(explosives[i]);
     }
     
 
     for (int i = 0; i < this.goodies.length; i++)
     {
       world.setBlockToAir(goodies[i]);
     }
   }


   private void   writePositionsToNbtTags(NBTTagCompound tagCompound,String key, BlockPos[] pos)
   {
     int[] lx = new int[pos.length];
     int[] ly = new int[pos.length];
     int[] lz = new int[pos.length];
     for(int i = 0; i < pos.length; i++)
     {
       lx[i] = pos[i].getX();
       ly[i] = pos[i].getY();
       lz[i] = pos[i].getZ();
     }
     tagCompound.setIntArray(key + "x",lx);
     tagCompound.setIntArray(key + "y",ly);
     tagCompound.setIntArray(key + "z",lz);

   }

   private BlockPos[]  readPositionsFromNbtTags(NBTTagCompound tagCompound,String key)
   {
     int[] lx =tagCompound.getIntArray(key + "x");
     int[] ly = tagCompound.getIntArray(key + "y");
     int[] lz = tagCompound.getIntArray(key + "z");

     BlockPos[] pos = new BlockPos[lx.length];

     for(int i = 0; i < lx.length; i++)
     {
       pos[i] = new BlockPos(lx[i],ly[i],lz[i]);
     }
     return  pos;
   }


   public void writeToNBT(NBTTagCompound par1NBTTagCompound)
   {
     super.writeToNBT(par1NBTTagCompound);
     this.writePositionsToNbtTags(par1NBTTagCompound,"goodies",this.goodies);
     this.writePositionsToNbtTags(par1NBTTagCompound,"explosiveBlocks",this.explosives);
   }

 
   public void readFromNBT(NBTTagCompound par1NBTTagCompound)
   {
     super.readFromNBT(par1NBTTagCompound);
    this.goodies= this.readPositionsFromNbtTags(par1NBTTagCompound,"goodies");
     this.explosives = this.readPositionsFromNbtTags(par1NBTTagCompound,"explosiveBlocks");

   }
 }

