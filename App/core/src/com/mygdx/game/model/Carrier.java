package com.mygdx.game.model;

import com.mygdx.game.controller.CellController;

import java.util.Arrays;

/**
 * Carrier class - 5 cells in an L (Builder)
 */
public class Carrier extends Ship {
    private static final int size = 5;
    /**
     * Carrier constructor
     */
    public Carrier() {
        super();
        cells = new CellController[size];
        Arrays.fill(cells, null);
    }
}
