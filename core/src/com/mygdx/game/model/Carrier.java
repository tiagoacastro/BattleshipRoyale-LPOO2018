package com.mygdx.game.model;

import java.util.Arrays;

/**
 * Carrier class - 5 cells in an L (Builder)
 */
public class Carrier extends Ship {
    private static final int size = 5;

    public Carrier() {
        super();
        cells = new Cell[size];
        Arrays.fill(cells, null);
    }
}
