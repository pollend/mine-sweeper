package com.minesweeper.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import com.minesweeper.MineSweeper;
import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;

public class BlockGoodies extends Block {

    @SideOnly(Side.CLIENT)
    public static IIcon[] numbers;
    @SideOnly(Side.CLIENT)
    public static IIcon cancle;

    Random rand = new Random();

    public BlockGoodies() {
        super(Material.rock);
        // super.c(1.5F);
        // super.b(10.0F);
        // super.r();

        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypePiston);

        this.setBlockName("Goodies");
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

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

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
                                    EntityPlayer player, int p_149727_6_, float p_149727_7_,
                                    float p_149727_8_, float p_149727_9_) {

        if (world.getBlockMetadata(x, y, z) == 15) {
            this.onBlockAdded(world, x, y, z);
        } else {
            world.setBlockMetadataWithNotify(x, y, z, 15, 2);
        }

        return super.onBlockActivated(world, x, y, z, player, p_149727_6_,
                p_149727_7_, p_149727_8_, p_149727_9_);
    }

    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityMineFieldCompletionSearch();
    }


    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta){
        TileEntityMineFieldCompletionSearch b = (TileEntityMineFieldCompletionSearch) world.getTileEntity(x, y, z);
        if (b != null) {
            if (b.IsMineFieldCompleted(world)) {
                b.ClearField(world);
            }
        }
        super.breakBlock(world, x, y, z, block, meta);
    }


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
    	world.setBlock(x, y, z, MineSweeperBlocks.blockFloatingNumber, meta, 2);
        
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


    @Override
    public void onBlockAdded(World world, int x, int y, int z) {

        int MineCount = 0;

        MineCount += IsMineBlock(x - 1, y - 1, z - 1, world);
        MineCount += IsMineBlock(x - 1, y - 1, z, world);
        MineCount += IsMineBlock(x - 1, y - 1, z + 1, world);

        MineCount += IsMineBlock(x + 1, y - 1, z - 1, world);
        MineCount += IsMineBlock(x + 1, y - 1, z, world);
        MineCount += IsMineBlock(x + 1, y - 1, z + 1, world);

        MineCount += IsMineBlock(x, y - 1, z - 1, world);
        MineCount += IsMineBlock(x, y - 1, z, world);
        MineCount += IsMineBlock(x, y - 1, z + 1, world);

        MineCount += IsMineBlock(x - 1, y + 1, z - 1, world);
        MineCount += IsMineBlock(x - 1, y + 1, z, world);
        MineCount += IsMineBlock(x - 1, y + 1, z + 1, world);

        MineCount += IsMineBlock(x + 1, y + 1, z - 1, world);
        MineCount += IsMineBlock(x + 1, y + 1, z, world);
        MineCount += IsMineBlock(x + 1, y + 1, z + 1, world);

        MineCount += IsMineBlock(x, y + 1, z - 1, world);
        MineCount += IsMineBlock(x, y + 1, z, world);
        MineCount += IsMineBlock(x, y + 1, z + 1, world);

        MineCount += IsMineBlock(x - 1, y, z - 1, world);
        MineCount += IsMineBlock(x - 1, y, z, world);
        MineCount += IsMineBlock(x - 1, y, z + 1, world);

        MineCount += IsMineBlock(x + 1, y, z - 1, world);
        MineCount += IsMineBlock(x + 1, y, z, world);
        MineCount += IsMineBlock(x + 1, y, z + 1, world);

        MineCount += IsMineBlock(x, y, z - 1, world);
        MineCount += IsMineBlock(x, y, z + 1, world);

        if (MineCount > 14) {
            MineCount = 14;
        }

        world.setBlockMetadataWithNotify(x, y, z, MineCount - 1, 2);

		/*
         * if (MineCount == 0) { world.e(x, y, z, 0); } else { world.c(x, y, z,
		 * MineCount); }
		 */
    }

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

    private int IsMineBlock(int x, int y, int z, World world) {
        return world.getBlock(x, y, z) instanceof BlockExplosiveMine ? 1 : 0;
    }
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