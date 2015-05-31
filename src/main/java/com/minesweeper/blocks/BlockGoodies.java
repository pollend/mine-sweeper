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


}

