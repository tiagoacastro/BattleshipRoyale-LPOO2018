package com.mygdx.game.model;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.controller.ShipController;

/**
 * Ship part that creates the boats and the board
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
    /**
     * Cell constructor
     * @param x         cell x
     * @param y         cell y
     * @param board     board controller
     */
    Cell(int x, int y, BoardController board){
        this.column = x;
        this.line = y;
        this.board = board;
    }
    /**
     * Checks if the cell is destroyed
     * @return  destroyed or not
     */
    public boolean check(){
        return destroyed;
    }
    /**
     * Setter for X
     * @param x     x
     */
    public void setX(int x) {
        this.column = x;
    }
    /**
     * Setter for Y
     * @param y     y
     */
    public void setY(int y) {
        this.line = y;
    }
    /**
     * Getter for X
     * @return  x
     */
    public int getX() {
        return column;
    }
    /**
     * Getter for Y
     * @return Y
     */
    public int getY() {
        return line;
    }
    /**
     * Getter for the board
     * @return board
     */
    public BoardController getBoard() {
        return board;
    }
    /**
     * Getter for the creation listener
     * @return  creation listener
     */
    public ClickListener getCreateListener() {
        return createListener;
    }
    /**
     * Getter for the shooting listener
     * @return  shooting listener
     */
    public ClickListener getShootListener() {
        return shootListener;
    }
    /**
     * Setter for the shooting listener
     * @param shootListener shooting listener
     */
    public void setShootListener(ClickListener shootListener) {
        this.shootListener = shootListener;
    }
    /**
     * Getter for the game controller
     * @return  game controller
     */
    public GameController getController() {
        return controller;
    }
    /**
     * Getter for the button
     * @return button
     */
    public Button getButton() {
        return button;
    }
    /**
     * Set the ship in charge of the cell
     * @param ship  ship
     */
    public void setShip(ShipController ship) {
        this.ship = ship;
    }
    /**
     * Set if the cell is destroyed or not
     * @param destroyed value
     */
    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    /**
     * Setter for the button
     * @param button    button
     */
    public void setButton(Button button) {
        this.button = button;
    }
    /**
     * Setter for the board
     * @param board board
     */
    public void setBoard(BoardController board) {
        this.board = board;
    }
    /**
     * Setter for the creation listener
     * @param createListener    creation listener
     */
    public void setCreateListener(ClickListener createListener) {
        this.createListener = createListener;
    }
    /**
     * Setter for the game controller
     * @param controller    game controller
     */
    public void setController(GameController controller) {
        this.controller = controller;
    }
    /**
     * Getter for the ship
     * @return  ship
     */
    public ShipController getShip() {
        return ship;
    }
}
