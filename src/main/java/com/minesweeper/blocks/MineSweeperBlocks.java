/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/

package com.minesweeper.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Michael on 5/26/2015.
 */
public class MineSweeperBlocks {

	public final static BlockExplosiveMine blockExplosiveMine;
	public final static BlockFloatingNumber blockFloatingNumber;
	public final static BlockGoodies blockGoodies;
	
	static{
		blockExplosiveMine = new BlockExplosiveMine();
		blockFloatingNumber = new BlockFloatingNumber();
		blockGoodies = new BlockGoodies();
	}
	
	public static void init()
	{


	}

	
}
