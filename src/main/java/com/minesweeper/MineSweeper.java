 package com.minesweeper;

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


/* Location:              C:\Users\Michael\Desktop\oldComputer\MinecraftMods\MineSweeper\!\MineSweeper\MineSweeper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */