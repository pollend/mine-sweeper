/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/

package com.minesweeper.blocks;

 import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;
 import net.minecraft.block.ITileEntityProvider;
 import net.minecraft.block.material.Material;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.BlockPos;
 import net.minecraft.world.Explosion;
 import net.minecraft.world.World;
 import net.minecraftforge.fml.common.registry.GameRegistry;

 import com.minesweeper.MineSweeper;


 public class BlockExplosiveMine
   extends BaseFieldBlock implements ITileEntityProvider
 {
     public final static String name = "explosivemine";
	 
	 
   public BlockExplosiveMine()
   {
     super(Material.rock);
       this.setUnlocalizedName(MineSweeper.MODID+"_"+name);
       this.setHardness(1.5F);
       this.setResistance(10.0F);
       this.setStepSound(soundTypePiston);
       GameRegistry.registerBlock(this, name);

   }

     @Override
     /**
      * triggers the minefield to bail and block up all the blocks
      */
     public boolean removedByPlayer(World worldIn, BlockPos pos, EntityPlayer player, boolean willHarvest)
     {
         onBlockExploded(worldIn,pos,null);
         return  true;
     }

     @Override
     public void onBlockExploded(World worldIn, BlockPos pos, Explosion explosion)
     {
         TileEntityMineFieldCompletionSearch compleitionSearch =((TileEntityMineFieldCompletionSearch) worldIn.getTileEntity(pos));
         BlockPos[] mines = compleitionSearch.getExplosives(worldIn);
         if(mines != null) {
             compleitionSearch.clearField(worldIn);
             for (int i = 0; i <mines.length ; i++) {
                 worldIn.createExplosion(null, mines[i].getX(), mines[i].getY(), mines[i].getZ(), 4.0f, true);
             }
         }
     }

     @Override
     public TileEntity createNewTileEntity(World worldIn, int meta) {
         return new TileEntityMineFieldCompletionSearch();
     }
 }
