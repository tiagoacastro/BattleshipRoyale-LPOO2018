package com.mygdx.game.model;

import com.mygdx.game.controller.CellController;

import java.util.Arrays;

/**
 * Dreadnought class - 4 consecutive cells (Builder)
 */
public class Dreadnought extends Ship {
    private static final int size = 4;
    /**
     * Dreadnough constructor
     */
    public Dreadnought() {
        super();
        cells = new CellController[size];
        Arrays.fill(cells, null);
    }
}
