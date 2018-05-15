package com.mygdx.game.model;

/**
 * Ship super class (Template)
 */
public abstract class Ship{
    protected int x;
    protected int y;
    protected Way way = Way.W;
    protected boolean destroyed = false;
    protected ShipCell cells[];

    enum Way{W, S, E, N}

    public Ship(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void update(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void rotate(){
        switch(way){
            case W:
                way = Way.S;
                break;
            case S:
                way = Way.E;
                break;
            case E:
                way = Way.N;
            case N:
                way = Way.W;
        }
    }

    public void revert(){
        switch(way){
            case W:
                way = Way.N;
                break;
            case S:
                way = Way.W;
                break;
            case E:
                way = Way.S;
            case N:
                way = Way.E;
        }
    }

    public void destroy(){
        destroyed = true;
    }

    public boolean check(){
        return destroyed;
    }
}
