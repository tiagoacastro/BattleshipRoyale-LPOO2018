package com.mygdx.game.model;

/**
 * Carrier class - 4 cells in an L (Builder)
 */
public class Carrier extends Ship {
    private final int size = 4;

    public Carrier(int x, int y) {
        super(x, y);
        cells = new ShipCell[size];
    }
}
