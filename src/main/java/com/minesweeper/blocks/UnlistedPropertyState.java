package com.minesweeper.blocks;

import net.minecraftforge.common.property.IUnlistedProperty;

/**
 * Created by Michael on 5/30/2015.
 */
public class UnlistedPropertyState implements IUnlistedProperty<Integer> {
    @Override
    public String getName() {
        return "basefieldstates";
    }

    @Override
    public boolean isValid(Integer value) {
        return true;
    }

    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override
    public String valueToString(Integer value) {
        return Integer.toString(value);
    }
}
