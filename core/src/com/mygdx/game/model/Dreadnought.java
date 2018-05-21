package com.mygdx.game.model;

import java.util.Arrays;

/**
 * Dreadnought class - 4 consecutive cells (Builder)
 */
public class Dreadnought extends Ship {
    private static final int size = 4;

    public Dreadnought() {
        super();
        cells = new Cell[size];
        Arrays.fill(cells, null);
    }
}
