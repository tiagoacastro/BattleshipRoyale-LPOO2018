package com.mygdx.game.model;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.ShipController;

/**
 * Ship part that creates the boats
 */
public class Cell {
    private Ship ship = null;
    private int column;
    private int line;
    private boolean destroyed = false;
    private TextButton creatorButton;
    private BoardController board;

    Cell(int x, int y, BoardController board){
        this.column = x;
        this.line = y;
        this.board = board;
    }

    public boolean occupied(Ship s){
        return s != ship && ship != null;
    }

    public void free(){
        this.ship = null;
        creatorButton.setText("c");                 //for testing
    }

    public void occupy(Ship ship){
        this.ship = ship;
        if(ship instanceof Carrier)                 //for testing
            creatorButton.setText("5");
        else if(ship instanceof Dreadnought)
            creatorButton.setText("4");
        else if(ship instanceof Submarine)
            creatorButton.setText("3");
        else if(ship instanceof Cruiser)
            creatorButton.setText("2");
        else if(ship instanceof PatrolBoat)
            creatorButton.setText("1");
    }

    public void destroy(){
        this.destroyed = true;
    }

    public boolean check(){
        return destroyed;
    }

    public void setX(int x) {
        this.column = x;
    }

    public void setY(int y) {
        this.line = y;
    }

    public int getX() {
        return column;
    }

    public int getY() {
        return line;
    }

    public TextButton getButton() {
        return creatorButton;
    }

    public void setButton(TextButton button) {
        this.creatorButton = button;
        button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                ShipController ship = board.getChosen();
                if(ship != null){
                    ship.update(board.getBoard(), column, line);
                }
            }
        });
    }
}
