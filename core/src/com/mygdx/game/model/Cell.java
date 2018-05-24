package com.mygdx.game.model;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Ship part that creates the boats
 */
public class Cell {
    private Ship ship = null;
    private int x;
    private int y;
    private boolean destroyed = false;
    private TextButton button;

    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean occupied(){
        return ship != null;
    }

    public void free(){
        this.ship = null;
    }

    public void occupy(Ship ship){
        this.ship = ship;
    }

    public void destroy(){
        this.destroyed = true;
    }

    public boolean check(){
        return destroyed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TextButton getButton() {
        return button;
    }

    public void setButton(TextButton button) {
        this.button = button;

    }
}
