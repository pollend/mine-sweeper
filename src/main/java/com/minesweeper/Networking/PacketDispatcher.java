/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/
package com.minesweeper.Networking;

import com.minesweeper.MineSweeper;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketDispatcher {
    private static byte packetId = 0;
    private static final SimpleNetworkWrapper dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(MineSweeper.MODID);

    public static final void registerPackets() {
        dispatcher.registerMessage(FieldClearedOnSuccess.Handler.class,FieldClearedOnSuccess.class,0, Side.CLIENT);
    }

    /**
     * send to everyone in a radius
     * @param message
     * @param point
     */
    public  static  final void  sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point)
    {
        dispatcher.sendToAllAround(message,point);
    }

    /**
     * send to Everyone across the server
     * @param message
     */
    public  static  final void   sendToEveryone(IMessage message)
    {
        dispatcher.sendToAll(message);
    }

    /**
     * send the packet to everyone in that dimension
     * @param message
     * @param dimensionId
     */
    public static final void sendToDimension(IMessage message, int dimensionId) {
        dispatcher.sendToDimension(message, dimensionId);
    }

    /**
     * send a packet from the client to the server
     * @param message
     */
    public static final void sendToServer(IMessage message) {
        dispatcher.sendToServer(message);
    }


}
