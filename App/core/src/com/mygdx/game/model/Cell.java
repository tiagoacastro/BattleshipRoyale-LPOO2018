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
        creatorButton.setText("c");
    }

    public void occupy(Ship ship){
        this.ship = ship;
        if(this.ship instanceof Carrier)
            this.creatorButton.setText("5");
        else if(this.ship instanceof Dreadnought)
            this.creatorButton.setText("4");
        else if(this.ship instanceof Submarine)
            this.creatorButton.setText("3");
        else if(this.ship instanceof Cruiser)
            this.creatorButton.setText("2");
        else if(this.ship instanceof PatrolBoat)
            this.creatorButton.setText("1");
    }

    public void destroy(){
        this.destroyed = true;

        this.ship.check();
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

    public TextButton getCreatorButton() {
        this.creatorButton.removeListener(createListener);
        return creatorButton;
    }

    public void setCreatorButton(TextButton button) {
        this.creatorButton = button;

        this.creatorButton.addListener(createListener = new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                ShipController ship = board.getChosen();
                if(ship != null){
                    ship.update(board.getBoard(), column, line);
                }
            }
        });
    }
    /*
    public TextButton getPlayButton() {
        return creatorButton;
    }

    public void setPlayButton(TextButton button) {
        this.playButton = button;

        if(ship != null)
            if(this.ship instanceof Carrier)
                this.playButton.setText("5");
            else if(this.ship instanceof Dreadnought)
                this.playButton.setText("4");
            else if(this.ship instanceof Submarine)
                this.playButton.setText("3");
            else if(this.ship instanceof Cruiser)
                this.playButton.setText("2");
            else if(this.ship instanceof PatrolBoat)
                this.playButton.setText("1");

        this.playButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                destroy();
            }
        });
    }*/
}
