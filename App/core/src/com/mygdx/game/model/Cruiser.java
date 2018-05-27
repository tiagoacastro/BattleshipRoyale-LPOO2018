package com.mygdx.game.model;

import java.util.Arrays;

/**
 * Cruiser class - 2 consecutive cells (Builder)
 */
public class Cruiser extends Ship {
    private static final int size = 2;

    public Cruiser() {
        super();
        cells = new Cell[size];
        Arrays.fill(cells, null);
    }
}
