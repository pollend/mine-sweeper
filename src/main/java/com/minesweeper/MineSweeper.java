 package com.minesweeper;


import com.minesweeper.blocks.BlockExplosiveMine;
import com.minesweeper.blocks.BlockFloatingNumber;
import com.minesweeper.blocks.BlockGoodies;
import com.minesweeper.blocks.MineSweeperBlocks;
import com.minesweeper.tileEntities.TileEntityFloatingNumber;
import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


 @Mod(modid = MineSweeper.MODID, version = MineSweeper.VERSION)
 public class MineSweeper
 {
	 
	 @SidedProxy(clientSide="com.minesweeper.ClientProxy", serverSide="com.minesweeper.CommonProxy")
	 public static CommonProxy proxy;
	 
    public static final String MODID = "minesweeper";
    public static final String VERSION = "1.0";

   @Mod.EventHandler
   public void Init(FMLPreInitializationEvent event) {
   }
   
   
   @Mod.EventHandler
   public void load(FMLInitializationEvent event)
   {
	   //GameRegistry.registerBlock(new BlockTrophy(),"Trophy");
	   GameRegistry.registerTileEntity(TileEntityFloatingNumber.class, "FloatingNumber");
	   GameRegistry.registerTileEntity(TileEntityMineFieldCompletionSearch.class, "Completion");
	  
	   MineSweeperBlocks.init();
	   
	   GameRegistry.registerWorldGenerator(new GenerateMineField(),5);
	   
	   proxy.RegisterRendering();
		  
	   

   }


 }

