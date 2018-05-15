package com.mygdx.game.model;

/**
 * Ship part that creates the boats
 */
public class ShipCell {
    private int x;
    private int y;
    private boolean destroyed = false;

    public ShipCell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void update(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void destroy(){
        this.destroyed = true;
    }

    public boolean check(){
        return destroyed;
    }
}
