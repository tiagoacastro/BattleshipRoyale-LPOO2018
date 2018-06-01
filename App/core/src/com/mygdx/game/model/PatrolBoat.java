package com.mygdx.game.model;

import com.mygdx.game.controller.CellController;

import java.util.Arrays;

/**
 * Patrol boat class - 1 cell (Builder)
 */
public class PatrolBoat extends Ship {
    private static final int size = 1;
    /**
     * Patrol Boat constructor
     */
    public PatrolBoat() {
        super();
        cells = new CellController[size];
        Arrays.fill(cells, null);
    }
}
