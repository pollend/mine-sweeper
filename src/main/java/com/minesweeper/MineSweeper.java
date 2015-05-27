 package com.minesweeper;

 import com.minesweeper.blocks.BlockExplosiveMine;
import com.minesweeper.blocks.BlockFloatingNumber;
import com.minesweeper.blocks.BlockGoodies;
import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;

import cpw.mods.fml.common.Mod;


 import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

 @Mod(modid = MineSweeper.MODID, version = MineSweeper.VERSION)
 public class MineSweeper
 {
            public static final String MODID = "minesweeper";
            public static final String VERSION = "1.0";

   @Mod.EventHandler
   public void preInit(FMLPreInitializationEvent event) {}
   
   @Mod.EventHandler
   public void load(FMLInitializationEvent event)
   {
     GameRegistry.registerBlock(new BlockGoodies(),"BlockGoodies");
     GameRegistry.registerBlock(new BlockFloatingNumber(),"FloatingNumber");
     GameRegistry.registerBlock(new BlockExplosiveMine(),"ExplosiveMine");
     //GameRegistry.registerBlock(new BlockTrophy(),"Trophy");
     
   //  GameRegistry.registerTileEntity(TileEntityDisembodiedNumber.class, "DisembodiedNumber");
     GameRegistry.registerTileEntity(TileEntityMineFieldCompletionSearch.class, "Completion");

     GameRegistry.registerWorldGenerator(new GenerateMineField(),5);

    // proxy.RegisterRendering();
   }


 }

