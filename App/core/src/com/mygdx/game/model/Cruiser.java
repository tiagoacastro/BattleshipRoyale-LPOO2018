package com.mygdx.game.model;

import com.mygdx.game.controller.CellController;

import java.util.Arrays;

/**
 * Cruiser class - 2 consecutive cells (Builder)
 */
public class Cruiser extends Ship {
    private static final int size = 2;
    /**
     * Cruiser constructor
     */
    public Cruiser() {
        super();
        cells = new CellController[size];
        Arrays.fill(cells, null);
    }
}
