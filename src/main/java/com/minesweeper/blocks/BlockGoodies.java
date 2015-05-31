package com.minesweeper.blocks;

import com.minesweeper.Networking.FieldClearedOnSuccess;
import com.minesweeper.Networking.PacketDispatcher;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityParticleEmitter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

import com.minesweeper.MineSweeper;
import com.minesweeper.tileEntities.TileEntityMineFieldCompletionSearch;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockGoodies  extends BaseFieldBlock  implements ITileEntityProvider {


    Random rand = new Random();

    public final static String name = "goodies";

    @Override
    public  int getStartingCount()
    {
        return  -1;
    }


    public BlockGoodies() {
        super(Material.rock);

        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setStepSound(soundTypePiston);

        this.setUnlocalizedName(MineSweeper.MODID+"_"+name);

        GameRegistry.registerBlock(this, name);
    }


/*
    public void c(World world, int x, int y, int z, int meta) {
        if (!par1World.J) {
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
                    }
    	world.setBlock(x, y, z, MineSweeperBlocks.blockFloatingNumber, meta, 2);
        
    }
*/
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        TileEntityMineFieldCompletionSearch compleitionSearch =((TileEntityMineFieldCompletionSearch) worldIn.getTileEntity(pos));
        if(compleitionSearch != null) {
            if (compleitionSearch.isMineFieldCompleted(worldIn)) {
                BlockPos[] mines = compleitionSearch.getExplosives(worldIn);
                for (int i = 0; i < mines.length; i++) {
                    ArrayList<ItemStack> lpossibleDrops = new ArrayList<ItemStack>();
                    lpossibleDrops.add(new ItemStack(Items.coal, worldIn.rand.nextInt(15)));
                    lpossibleDrops.add(new ItemStack(Items.diamond, worldIn.rand.nextInt(3)));
                    lpossibleDrops.add(new ItemStack(Items.redstone, worldIn.rand.nextInt(20)));

                    for (int x = 0; x < lpossibleDrops.size(); x++) {
                        Block.spawnAsEntity(worldIn, mines[i], lpossibleDrops.get(x));
                    }

                }
                PacketDispatcher.sendToAllAround(new FieldClearedOnSuccess(mines), new NetworkRegistry.TargetPoint(player.dimension,player.posX,player.posY,player.posZ,100));
                compleitionSearch.clearField(worldIn);
            }
        }

    }



    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.setBlockState(pos, MineSweeperBlocks.blockFloatingNumber.getDefaultState(), 2);
        worldIn.getTileEntity(pos).invalidate();
    }


    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMineFieldCompletionSearch();
    }


/*
    private void ChanceToSpawnGoods(World world, int x, int y, int z, amj b,
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




}

