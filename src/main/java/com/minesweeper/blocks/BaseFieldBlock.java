package com.minesweeper.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Michael on 5/27/2015.
 */
public class BaseFieldBlock  extends Block{

    public static final PropertyInteger STATES = PropertyInteger.create("states", 0, 15);

    protected BaseFieldBlock(Material materialIn) {

        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(STATES,Integer.valueOf(0)));
    }
    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {STATES});
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {

        return getDefaultState().withProperty(STATES, Integer.valueOf(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int value = ((Integer)state.getValue(STATES)).intValue();
        return value;
    }


    public  int getStartingCount()
    {
        return  0;
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
            int MineCount = getStartingCount();
            MineCount += IsMineBlock(pos.add(-1, -1, -1), world);
            MineCount += IsMineBlock(pos.add(-1, -1, 0), world);
            MineCount += IsMineBlock(pos.add(-1, -1, 1), world);

            MineCount += IsMineBlock(pos.add(1, -1, -1), world);
            MineCount += IsMineBlock(pos.add(1, -1, 0), world);
            MineCount += IsMineBlock(pos.add(1, -1, 1), world);

            MineCount += IsMineBlock(pos.add(0, -1, -1), world);
            MineCount += IsMineBlock(pos.add(0, -1, 0), world);
            MineCount += IsMineBlock(pos.add(0, -1, 1), world);


            MineCount += IsMineBlock(pos.add(-1, 1, -1), world);
            MineCount += IsMineBlock(pos.add(-1, 1, 0), world);
            MineCount += IsMineBlock(pos.add(-1, 1, 1), world);

            MineCount += IsMineBlock(pos.add(1, 1, -1), world);
            MineCount += IsMineBlock(pos.add(1, 1, 0), world);
            MineCount += IsMineBlock(pos.add(1, 1, 1), world);

            MineCount += IsMineBlock(pos.add(0, 1, -1), world);
            MineCount += IsMineBlock(pos.add(0, 1, 0), world);
            MineCount += IsMineBlock(pos.add(0, 1, 1), world);


            MineCount += IsMineBlock(pos.add(-1, 0, -1), world);
            MineCount += IsMineBlock(pos.add(-1, 0, 0), world);
            MineCount += IsMineBlock(pos.add(-1, 0, 1), world);

            MineCount += IsMineBlock(pos.add(1, 0, -1), world);
            MineCount += IsMineBlock(pos.add(1, 0, 0), world);
            MineCount += IsMineBlock(pos.add(1, 0, 1), world);

            MineCount += IsMineBlock(pos.add(0, 0, -1), world);

            MineCount += IsMineBlock(pos.add(0, 0, 1), world);


            if (MineCount > 14) {
                MineCount = 14;
            }
            if(MineCount < 0)
                MineCount = 0;

            world.setBlockState(pos, state.withProperty(STATES, Integer.valueOf(MineCount)), 2);
    }

    private int IsMineBlock(BlockPos pos, World world)
    {

        return world.getBlockState(pos).getBlock() instanceof BlockExplosiveMine ? 1 : 0;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        int marked = ((Integer)world.getBlockState(pos).getValue(STATES)).intValue();
        if (marked == 15) {
            this.onBlockAdded(world,pos,state);
        } else {
            world.setBlockState(pos,state.withProperty(STATES,Integer.valueOf(15)));
        }

        return super.onBlockActivated(world, pos,state,playerIn,side,hitX,hitY,hitZ);
    }

}
