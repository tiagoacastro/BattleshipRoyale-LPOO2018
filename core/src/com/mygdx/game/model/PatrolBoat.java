package com.mygdx.game.model;

/**
 * Patrol boat class - 1 cell (Builder)
 */
public class PatrolBoat extends Ship {
    private final int size = 1;

    public PatrolBoat(int x, int y) {
        super(x, y);
        cells = new ShipCell[size];
    }
}
