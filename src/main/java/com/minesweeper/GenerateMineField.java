 package com.minesweeper;
 
 import cpw.mods.fml.common.IWorldGenerator;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Random;

 import net.minecraft.world.World;
 import net.minecraft.world.chunk.IChunkProvider;

 
 public class GenerateMineField
   implements IWorldGenerator
 {
   private final int CHUNKSIZE = 16;
   
   List xGoodieBlock = new ArrayList();
   List yGoodieBlock = new ArrayList();
   List zGoodieBlock = new ArrayList();
   
   List xMineBlock = new ArrayList();
   List yMineBlock = new ArrayList();
   List zMineBlock = new ArrayList();


   @Override
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
     int y = random.nextInt(63) - 15;
     int x = chunkX * 16 + random.nextInt(16);
     int z = chunkZ * 16 + random.nextInt(16);
     int size = random.nextInt(40) + 40;
     if (random.nextFloat() * 100.0F > 97.0F)
     {
 
       this.xGoodieBlock = new ArrayList();
       this.yGoodieBlock = new ArrayList();
       this.zGoodieBlock = new ArrayList();
       
       this.xMineBlock = new ArrayList();
       this.yMineBlock = new ArrayList();
       this.zMineBlock = new ArrayList();
       
 
 
       for (int i = size; i > 0; i--) {
         AddMine(x + random.nextInt(10) - 5, y + random.nextInt(10) - 5, z + random.nextInt(10) - 5, world);
       }
       
       for (int i = 0; i < this.xGoodieBlock.size(); i++)
       {
         if (world.getBlock(((Integer)this.xGoodieBlock.get(i)).intValue(), ((Integer)this.yGoodieBlock.get(i)).intValue(), ((Integer)this.zGoodieBlock.get(i))).getClass() != BlockGoodies.class)
         {
           this.xGoodieBlock.remove(i);
           this.yGoodieBlock.remove(i);
           this.zGoodieBlock.remove(i);
           i--;
         }
       }
       
 
       for (int i = 0; i < this.xGoodieBlock.size(); i++)
       {

         world.setBlock(((Integer)this.xGoodieBlock.get(i)).intValue(), ((Integer)this.yGoodieBlock.get(i)).intValue(), ((Integer)this.zGoodieBlock.get(i)).intValue(), new BlockGoodies());
         TileEntityMineFieldCompletionSearch t = (TileEntityMineFieldCompletionSearch)world.getTileEntity(((Integer) this.xGoodieBlock.get(i)).intValue(), ((Integer) this.yGoodieBlock.get(i)).intValue(), ((Integer) this.zGoodieBlock.get(i)).intValue());
         
 
         t.xNumberBlocks = new int[this.xGoodieBlock.size()];
         t.yNumberBlocks = new int[this.xGoodieBlock.size()];
         t.zNumberBlocks = new int[this.xGoodieBlock.size()];
         
         t.xExplosiveBlocks = new int[this.xMineBlock.size()];
         t.yExplosiveBlocks = new int[this.xMineBlock.size()];
         t.zExplosiveBlocks = new int[this.xMineBlock.size()];
         
         t.xExplosiveBlocks = ConvertingListOfIntegersToArray(this.xMineBlock);
         t.yExplosiveBlocks = ConvertingListOfIntegersToArray(this.yMineBlock);
         t.zExplosiveBlocks = ConvertingListOfIntegersToArray(this.zMineBlock);
         
         t.xNumberBlocks = ConvertingListOfIntegersToArray(this.xGoodieBlock);
         t.yNumberBlocks = ConvertingListOfIntegersToArray(this.yGoodieBlock);
         t.zNumberBlocks = ConvertingListOfIntegersToArray(this.zGoodieBlock);
       }
     }
   }
   
 
 
 
 
   private int[] ConvertingListOfIntegersToArray(List lst)
   {
     int[] array = new int[lst.size()];
     for (int x = 0; x < lst.size(); x++)
     {
       array[x] = ((Integer)lst.get(x)).intValue();
     }
     return array;
   }
   
   public void AddMine(int x, int y, int z, World world)
   {
     if (world.getBlock(x, y, z).getClass() != BlockExplosiveMine.class)
     {
       world.setBlock(x, y, z, new BlockExplosiveMine());
       this.xMineBlock.add(Integer.valueOf(x));
       this.yMineBlock.add(Integer.valueOf(y));
       this.zMineBlock.add(Integer.valueOf(z));
       
 
       SetNumberBlock(x - 1, y - 1, z - 1, world);
       SetNumberBlock(x - 1, y - 1, z, world);
       SetNumberBlock(x - 1, y - 1, z + 1, world);
       
       SetNumberBlock(x + 1, y - 1, z - 1, world);
       SetNumberBlock(x + 1, y - 1, z, world);
       SetNumberBlock(x + 1, y - 1, z + 1, world);
       
       SetNumberBlock(x, y - 1, z - 1, world);
       SetNumberBlock(x, y - 1, z, world);
       SetNumberBlock(x, y - 1, z + 1, world);
       
 
       SetNumberBlock(x - 1, y + 1, z - 1, world);
       SetNumberBlock(x - 1, y + 1, z, world);
       SetNumberBlock(x - 1, y + 1, z + 1, world);
       
       SetNumberBlock(x + 1, y + 1, z - 1, world);
       SetNumberBlock(x + 1, y + 1, z, world);
       SetNumberBlock(x + 1, y + 1, z + 1, world);
       
       SetNumberBlock(x, y + 1, z - 1, world);
       SetNumberBlock(x, y + 1, z, world);
       SetNumberBlock(x, y + 1, z + 1, world);
       
 
       SetNumberBlock(x - 1, y, z - 1, world);
       SetNumberBlock(x - 1, y, z, world);
       SetNumberBlock(x - 1, y, z + 1, world);
       
       SetNumberBlock(x + 1, y, z - 1, world);
       SetNumberBlock(x + 1, y, z, world);
       SetNumberBlock(x + 1, y, z + 1, world);
       
       SetNumberBlock(x, y, z - 1, world);
       SetNumberBlock(x, y, z + 1, world);
     }
   }
   
 
   public void SetNumberBlock(int x, int y, int z, World world)
   {
     if (world.getBlock(x, y, z).getClass() == BlockExplosiveMine.class)
     {
 
       world.setBlock(x, y, z, new BlockExplosiveMine());
     }
     
 
     if ((world.getBlock(x, y, z).getClass() != BlockExplosiveMine.class) && (world.getBlock(x, y, z).getClass() != BlockGoodies.class))
     {
 
       world.setBlock(x, y, z, new BlockGoodies());
       
 
       this.xGoodieBlock.add(Integer.valueOf(x));
       this.yGoodieBlock.add(Integer.valueOf(y));
       this.zGoodieBlock.add(Integer.valueOf(z));
     }
   }


 }
