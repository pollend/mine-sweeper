 package com.minesweeper.tileEntities;

 import com.minesweeper.blocks.BlockExplosiveMine;
import com.minesweeper.blocks.BlockFloatingNumber;

 import net.minecraft.block.state.IBlockState;
 import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.BlockPos;
 import net.minecraft.world.World;
 import scala.Console;


 public class TileEntityMineFieldCompletionSearch
   extends BaseTileFieldEntity
 {
   public BlockPos[] goodies =new BlockPos[0];
   public BlockPos[] explosives =new BlockPos[0];
   public BlockPos refrence = new BlockPos(0,0,0);

   public  TileEntityMineFieldCompletionSearch()
   {

   }

@Override
   public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
   {
     return  false;
   }

 public TileEntityMineFieldCompletionSearch(BlockPos refrence,BlockPos[] goodies, BlockPos[] explosives)
 {
   this.refrence = refrence;
   this.goodies = goodies;
   this.explosives = explosives;
 }

   public boolean IsMineFieldCompleted(World world)
   {
     if(this.refrence.equals(this.getPos())) {
       if (this.explosives.length == 0) {
         return false;
       }
       for (int i = 0; i < this.explosives.length; i++) {
         if (!(world.getBlockState(explosives[i]).getBlock() instanceof BlockExplosiveMine)) {
           return false;
         }
       }
       for (int i = 0; i < this.goodies.length; i++) {
         if (!((world.getBlockState(goodies[i])).getBlock() instanceof BlockFloatingNumber)) {
           return false;
         }
       }
     }
     else
     {
       return ((TileEntityMineFieldCompletionSearch)world.getTileEntity(refrence)).IsMineFieldCompleted(this.getWorld());
     }
     return true;
   }
 
   public void ClearField(World world)
   {
     if(this.refrence.equals(this.getPos())) {
       for (int i = 0; i < this.explosives.length; i++) {
         world.setBlockToAir(explosives[i]);
       }


       for (int i = 0; i < this.goodies.length; i++) {
         world.setBlockToAir(goodies[i]);
       }
     }
     else {
       ((TileEntityMineFieldCompletionSearch)world.getTileEntity(refrence)).ClearField(this.getWorld());
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

      if(refrence.equals(this.getPos())) {

         this.writePositionsToNbtTags(par1NBTTagCompound, "goodies", this.goodies);
         this.writePositionsToNbtTags(par1NBTTagCompound, "explosiveBlocks", this.explosives);
       }
        par1NBTTagCompound.setInteger("refrence_x",refrence.getX());
        par1NBTTagCompound.setInteger("refrence_y",refrence.getY());
        par1NBTTagCompound.setInteger("refrence_z",refrence.getZ());


     }

 
   public void readFromNBT(NBTTagCompound par1NBTTagCompound)
   {
     super.readFromNBT(par1NBTTagCompound);
     this.refrence = new BlockPos(par1NBTTagCompound.getInteger("refrence_x"),par1NBTTagCompound.getInteger("refrence_y"),par1NBTTagCompound.getInteger("refrence_z"));
     if(refrence.equals(this.getPos())) {
       this.goodies = this.readPositionsFromNbtTags(par1NBTTagCompound, "goodies");
       this.explosives = this.readPositionsFromNbtTags(par1NBTTagCompound, "explosiveBlocks");
     }


   }
 }

