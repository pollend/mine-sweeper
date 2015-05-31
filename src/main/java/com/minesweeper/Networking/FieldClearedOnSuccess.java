package com.minesweeper.Networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Michael on 5/30/2015.
 */
public class FieldClearedOnSuccess implements IMessage {

    private  BlockPos[] mines = new BlockPos[0];

    public  FieldClearedOnSuccess(){

    }

    public  FieldClearedOnSuccess(BlockPos[] pos){
        mines = pos;
    }

    public  BlockPos[] getMines()
    {
        return  mines;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        int length = buf.readInt();
        mines = new BlockPos[length];
        for (int x = 0; x < length; x++)
        {
            mines[x] = new BlockPos(buf.readInt(),buf.readInt(),buf.readInt());
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(mines.length);
        for(int x = 0;x < mines.length; x++)
        {
            buf.writeInt(mines[x].getX());
            buf.writeInt(mines[x].getY());
            buf.writeInt(mines[x].getZ());
        }
    }

    public  static  class Handler implements IMessageHandler<FieldClearedOnSuccess, IMessage>
    {


        @Override
        public IMessage onMessage(final FieldClearedOnSuccess message, MessageContext ctx) {
            Minecraft minecraft = Minecraft.getMinecraft();
           final WorldClient world = minecraft.theWorld;
            minecraft.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    BlockPos[] mines =  message.getMines();
                    for(int x = 0; x < mines.length; x++)
                    {
                        for(int i = 0; i< 5; i++) {
                            double d1 = (double) mines[x].getX() + (world.rand.nextDouble());
                            double d2 = (double) mines[x].getY() + world.rand.nextDouble();
                            double d3 = (double) mines[x].getZ() + (world.rand.nextDouble());
                            world.spawnParticle(EnumParticleTypes.CLOUD, d1, d2, d3, 0, 0, 0, new int[0]);
                        }
                    }
                }
            });

            return null;
        }
    }
}
