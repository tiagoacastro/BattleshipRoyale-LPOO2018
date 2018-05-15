package com.mygdx.game.model;

/**
 * Cruiser class - 2 consecutive cells (Builder)
 */
public class Cruiser extends Ship {
    private final int size = 2;

    public Cruiser(int x, int y) {
        super(x, y);
        cells = new ShipCell[size];
    }
}
