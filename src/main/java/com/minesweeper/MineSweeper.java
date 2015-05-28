 package com.minesweeper;


import com.minesweeper.blocks.MineSweeperBlocks;
import com.minesweeper.generate.GenerateMineField;
import com.minesweeper.tileEntities.TileEntityFloatingNumber;
import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

 @Mod(modid = MineSweeper.MODID, version = MineSweeper.VERSION)
 public class MineSweeper
 {
	 
	 @SidedProxy(clientSide="com.minesweeper.ClientProxy", serverSide="com.minesweeper.CommonProxy")
	 public static CommonProxy proxy;
	 
    public static final String MODID = "minesweeper";
    public static final String VERSION = "1.0";
   @EventHandler
   public void preinit(FMLPreInitializationEvent event)
   {
       //event handler registry

       //block
       MineSweeperBlocks.init();
       //items

       GameRegistry.registerTileEntity(TileEntityFloatingNumber.class, "FloatingNumber");
       GameRegistry.registerTileEntity(TileEntityMineFieldCompletionSearch.class, "Completion");

   }


     @EventHandler
     public void init(FMLInitializationEvent event)
   {

	   GameRegistry.registerWorldGenerator(new GenerateMineField(),5);
	   
	   proxy.RegisterRendering();

       //register renders
       if(event.getSide() == Side.CLIENT)
       {

       }


   }


 }

