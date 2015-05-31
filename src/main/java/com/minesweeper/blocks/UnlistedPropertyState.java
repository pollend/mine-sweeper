/**
 * Copyright (c) 2011-2015, Michael Pollind
 **/

package com.minesweeper.blocks;

import net.minecraftforge.common.property.IUnlistedProperty;

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
