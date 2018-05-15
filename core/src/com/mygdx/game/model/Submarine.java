package com.mygdx.game.model;

/**
 * Submarine class - 3 consecutive cells (Builder)
 */
public class Submarine extends Ship {
    private final int size = 3;

    public Submarine(int x, int y) {
        super(x, y);
        cells = new ShipCell[size];
    }
}
