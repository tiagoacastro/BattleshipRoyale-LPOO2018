package com.mygdx.game.model;

import java.util.Arrays;

/**
 * Patrol boat class - 1 cell (Builder)
 */
public class PatrolBoat extends Ship {
    private static final int size = 1;

    public PatrolBoat() {
        super();
        cells = new Cell[size];
        Arrays.fill(cells, null);
    }
}
