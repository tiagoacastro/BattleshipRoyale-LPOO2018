package com.mygdx.game.model;

/**
 * Dreadnought class - 4 consecutive cells (Builder)
 */
public class Dreadnought extends Ship {
    private final int size = 4;

    public Dreadnought(int x, int y) {
        super(x, y);
        cells = new ShipCell[size];
    }
}
