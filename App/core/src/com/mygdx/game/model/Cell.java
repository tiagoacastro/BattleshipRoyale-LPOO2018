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
    private TextButton button;
    private BoardController board;
    private ClickListener createListener;

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
        button.setText("c");
    }

    public void occupy(Ship ship){
        this.ship = ship;

        if(this.ship instanceof Carrier)
            this.button.setText("5");
        else if(this.ship instanceof Dreadnought)
            this.button.setText("4");
        else if(this.ship instanceof Submarine)
            this.button.setText("3");
        else if(this.ship instanceof Cruiser)
            this.button.setText("2");
        else if(this.ship instanceof PatrolBoat)
            this.button.setText("1");
    }

    private void destroy(){
        if(ship != null) {
            this.destroyed = true;

            this.button.setText("*");

            this.ship.check();
        }
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
        this.button.removeListener(createListener);
        return button;
    }

    public void setButton(TextButton button) {
        this.button = button;

        this.button.addListener(createListener = new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                ShipController ship = board.getChosen();
                if(ship != null){
                    ship.update(board.getBoard(), column, line);
                }
            }
        });
    }

    public void initPlay(){
        this.button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                destroy();
            }
        });
    }
}
