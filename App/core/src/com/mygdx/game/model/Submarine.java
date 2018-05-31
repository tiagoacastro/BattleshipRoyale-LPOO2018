package com.mygdx.game.model;

import com.mygdx.game.controller.CellController;

import java.util.Arrays;

/**
 * Submarine class - 3 consecutive cells (Builder)
 */
public class Submarine extends Ship {
    private static final int size = 3;

    public Submarine() {
        super();
        cells = new CellController[size];
        Arrays.fill(cells, null);
    }
}
