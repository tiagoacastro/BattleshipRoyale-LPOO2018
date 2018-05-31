package com.mygdx.game.model;

import com.mygdx.game.controller.CellController;

/**
 * Ship super class (Template)
 */
public abstract class Ship{
    protected int x = -1;
    protected int y = -1;
    Way way = Way.W;
    private boolean destroyed = false;
    CellController cells[];

    public enum Way{W, S, E, N}

    Ship(){}

    public void destroy(){
        destroyed = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Way getWay() {
        return way;
    }

    public void setWay(Way way) {
        this.way = way;
    }

    public CellController[] getCells() {
        return cells;
    }

    public boolean check(){
        return destroyed;
    }
}
