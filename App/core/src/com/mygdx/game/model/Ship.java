package com.mygdx.game.model;

import com.mygdx.game.controller.CellController;

/**
 * Ship super class (Template)
 */
public abstract class Ship{
    protected int x = -1;
    protected int y = -1;
    private Way way = Way.W;
    private boolean destroyed = false;
    CellController cells[];
    /**
     * The 4 ways the ship can be facing
     */
    public enum Way{W, S, E, N}
    /**
     * Ship default constructor
     */
    Ship(){}
    /**
     * Destroy the ship
     */
    public void destroy(){
        destroyed = true;
    }
    /**
     * Getter for the x of the first cell
     * @return  x
     */
    public int getX() {
        return x;
    }
    /**
     * Setter for the x of the first cell
     * @param x x
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Getter for the y of the first cell
     * @return  y
     */
    public int getY() {
        return y;
    }
    /**
     * Setter for the y of the first cell
     * @param y y
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * Getter for the way of the boat
     * @return way
     */
    public Way getWay() {
        return way;
    }
    /**
     * Setter for the way of the boat
     * @param way   way
     */
    public void setWay(Way way) {
        this.way = way;
    }
    /**
     * Getter for the cells that make up the ship
     * @return  cells
     */
    public CellController[] getCells() {
        return cells;
    }
    /**
     * Checks if the boat is destroyed
     * @return  if it's destroyed or not
     */
    public boolean check(){
        return destroyed;
    }
}
