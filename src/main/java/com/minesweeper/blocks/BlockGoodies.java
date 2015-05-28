package com.minesweeper.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import com.minesweeper.MineSweeper;
import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockGoodies  extends BaseFieldBlock{


    Random rand = new Random();

    public final static String name = "goodies";

    @Override
    public  int getStartingCount()
    {
        return  -1;
    }


    public BlockGoodies() {
        super(Material.rock);
        // super.c(1.5F);
        // super.b(10.0F);
        // super.r();

        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypePiston);

        this.setUnlocalizedName(MineSweeper.MODID+"_"+name);

        this.setCreativeTab(CreativeTabs.tabBlock);
        GameRegistry.registerBlock(this, name);
    }
/*
    @Override
    public void registerBlockIcons(IIconRegister icon) {
        numbers = new IIcon[13];

        this.cancle = icon.registerIcon(MineSweeper.MODID + ":" + "cancel");

        for (int x = 0; x < numbers.length; x++) {
            numbers[x] = icon.registerIcon(MineSweeper.MODID + ":" + "stone-"
                    + (x + 1));
        }
        // blockIcon = icon.registerIcon(ModInfo.ID.toLowerCase() + ":" +
        // Names.tutBlock_unlocalizedName);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        if (metadata == 15)
            return cancle;
        else
            return numbers[metadata];

    }
*/

  /*  public boolean hasTileEntity(int metadata) {
        return true;
    }*/

   // @Override
   // public TileEntity createTileEntity(World world, int metadata) {
      //  return new TileEntityMineFieldCompletionSearch();
   // }

/*
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
      /*  TileEntityMineFieldCompletionSearch b = (TileEntityMineFieldCompletionSearch) world.getTileEntity(x, y, z);
        if (b != null) {
            if (b.IsMineFieldCompleted(world)) {
                b.ClearField(world);
            }
        }*/
        //super.breakBlock(world, pos, state);
    //}




    public void c(World world, int x, int y, int z, int meta) {
        /*if (!par1World.J) {
            int metaData = par1World.h(par2, par3, par4) + 1;
            switch (metaData) {
                case 1:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.01F, 1.0F, this.rand);

                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 1.0F, 0.5F,
                            this.rand);
                    break;
                case 2:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.05F, 0.02F, this.rand);

                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 1.0F, 0.3F,
                            this.rand);
                    break;
                case 3:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.1F, 0.05F, this.rand);

                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 1.0F, 0.2F,
                            this.rand);
                    break;
                case 4:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.15F, 0.05F, this.rand);

                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 1.0F, 0.1F,
                            this.rand);
                    break;
                case 5:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.2F, 0.05F, this.rand);

                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 1.1F, 0.1F,
                            this.rand);
                    break;
                case 6:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.4F, 0.1F, this.rand);

                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 1.4F, 0.1F,
                            this.rand);
                    break;
                case 7:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.4F, 0.05F, this.rand);

                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 1.8F, 0.1F,
                            this.rand);
                    break;
                case 8:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.5F, 0.02F, this.rand);

                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 2.0F, 0.1F,
                            this.rand);
                    break;
                case 9:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.6F, 0.02F, this.rand);

                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 2.4F, 0.1F,
                            this.rand);

                    break;
                case 10:
                    ChanceToSpawnGoods(par1World, par2, par3, par4, uk.n,
                            0.8F, 0.01F, this.rand);


                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 2.7F, 0.1F,
                            this.rand);
                    break;
                case 11:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 0.9F, 0.01F, this.rand);


                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 1.9F, 0.1F,
                            this.rand);
                    break;
                case 12:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 1.0F, 0.01F, this.rand);


                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 2.0F, 0.1F,
                            this.rand);
                    break;
                case 13:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 1.4F, 0.01F, this.rand);


                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 3.0F, 0.1F,
                            this.rand);
                    break;
                case 14:
                    ChanceToSpawnGoods(par1World, par2, par3,
                            par4, uk.n, 2.0F, 0.01F, this.rand);


                    ChanceToSpawnGoods(par1World, par2, par3, par4, amj.K, 4.0F, 0.1F,
                            this.rand);
            }


            px var14 = new px(par1World, par2, par3, par4, new um(1, 1, 1));

            var14.w = ((float) this.rand.nextGaussian() * 0.2F);
            var14.x =
                    ((float) this.rand.nextGaussian() * 0.2F + 0.2F);
            var14.y =
                    ((float) this.rand.nextGaussian() * 0.2F);
                    }*/
    	//world.setBlock(x, y, z, MineSweeperBlocks.blockFloatingNumber, meta, 2);
        
    }
/*
    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        if(world.setBlockState(pos, MineSweeperBlocks.blockFloatingNumber.getDefaultState(), 2))
        {
            world.getBlockState(pos).withProperty(BaseFieldBlock.STATES,state.getValue(BaseFieldBlock.STATES));
        }

    }
*/
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn,pos,state);
        if(worldIn.setBlockState(pos, MineSweeperBlocks.blockFloatingNumber.getDefaultState(), 2))
        {
            worldIn.getBlockState(pos).withProperty(BaseFieldBlock.STATES, state.getValue(BaseFieldBlock.STATES));
        }
    }



 /*   private void ChanceToSpawnGoods(World world, int x, int y, int z, amj b,
                                    float chance, float chanceDecrease, Random rand) {
        while (chance > 0.0F) {
            if (rand.nextFloat() > chance) {
                break;
            }
            world.d(new px(world, x, y,
                    z, new um(b.cm, 1, 1)));
            chance -= chanceDecrease;
        }
    }


    private void ChanceToSpawnGoods(World world, int x, int y, int z, uk
            item, float chance, float chanceDecrease, Random rand) {
        while (chance >
                0.0F) {
            if (rand.nextFloat() > chance) {
                break;
            }

            //world.d(new px(world, x, y, z, new um(item, 1, 1))); chance -=
            chanceDecrease;
        }
    }*/


/*
    public boolean a(World par1World, int par2, int par3, int par4, qx, par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if(par5EntityPlayer.bI.g().b() == uk.D) {
            if (par1World.h(par2, par3, par4) == 15) {
                g(par1World, par2, par3,par4);
            } else par1World.d(par2, par3, par4, 15);
        }
        return this.cp;
    }
*/

	/*
	 * public int a(Random par1Random) { return 0; }
	 */
	/*
	 * public int a(int par1, int par2) { return par2 - 1; }
	 */
}

/*
 * Location:
 * C:\Users\Michael\Desktop\oldComputer\MinecraftMods\MineSweeper\!\MineSweeper
 * \BlockGoodies.class Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */