package com.mygdx.game.model;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.controller.ShipController;

/**
 * Ship part that creates the boats
 */
public class Cell {
    private ShipController ship = null;
    private int column;
    private int line;
    private boolean destroyed = false;
    private Button button;
    private BoardController board;
    private ClickListener createListener;
    private ClickListener shootListener = null;
    private GameController controller;

    Cell(int x, int y, BoardController board){
        this.column = x;
        this.line = y;
        this.board = board;
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

    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }

    public BoardController getBoard() {
        return board;
    }

    public ClickListener getCreateListener() {
        return createListener;
    }

    public ClickListener getShootListener() {
        return shootListener;
    }

    public GameController getController() {
        return controller;
    }

    public Button getButton() {
        return button;
    }

    public void setShip(ShipController ship) {
        this.ship = ship;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setBoard(BoardController board) {
        this.board = board;
    }

    public void setCreateListener(ClickListener createListener) {
        this.createListener = createListener;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public ShipController getShip() {
        return ship;
    }
}
