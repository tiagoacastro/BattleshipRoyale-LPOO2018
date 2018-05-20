package com.mygdx.game.model;

import java.util.Arrays;

/**
 * Submarine class - 3 consecutive cells (Builder)
 */
public class Submarine extends Ship {
    private final int size = 3;

    public Submarine() {
        super();
        cells = new Cell[size];
        Arrays.fill(cells, null);
    }
}
