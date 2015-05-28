 package com.minesweeper;


import com.minesweeper.Render.RenderFloatingNumber;
import com.minesweeper.blocks.MineSweeperBlocks;
import com.minesweeper.generate.GenerateMineField;
import com.minesweeper.tileEntities.TileEntityFloatingNumber;
import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;

import net.minecraftforge.fml.client.registry.ClientRegistry;
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

    public static final String MODID = "minesweeper";
    public static final String VERSION = "1.0";
   @EventHandler
   public void preinit(FMLPreInitializationEvent event)
   {
       //event handler registry

       //block

       //items
   }


     @EventHandler
     public void init(FMLInitializationEvent event)
   {
       GameRegistry.registerTileEntity(TileEntityFloatingNumber.class, TileEntityFloatingNumber.name);
       GameRegistry.registerTileEntity(TileEntityMineFieldCompletionSearch.class, "Completion");

       MineSweeperBlocks.init();

	   GameRegistry.registerWorldGenerator(new GenerateMineField(),5);

       //register renders
       if(event.getSide() == Side.CLIENT)
       {

           ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFloatingNumber.class,new RenderFloatingNumber());
       }


   }


 }

