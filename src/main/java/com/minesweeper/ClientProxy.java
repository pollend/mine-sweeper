package com.minesweeper;

import com.minesweeper.Render.RenderFloatingNumber;
import com.minesweeper.tileEntities.TileEntityFloatingNumber;

import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	@Override  
	public void RegisterRendering() {
		//ClientRegistry.registerTileEntity(TileEntityFloatingNumber.class, "TileEntityFloatingNumber", new RenderFloatingNumber());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFloatingNumber.class, new RenderFloatingNumber());
		  
	}
}
