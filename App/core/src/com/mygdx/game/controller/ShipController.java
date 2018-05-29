package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Ship;
import com.mygdx.game.model.Cell;

import java.util.Arrays;

/**
 * ShipController class in charge of every operation on the ship model
 */
public class ShipController {
    Ship shipModel;
    private boolean placed = false;
    /**
     * ShipController constructor that receives the ship model
     * @param ship  ship model
     */
    ShipController(Ship ship) {
        this.shipModel = ship;
    }
    /**
     * function to check all the cells occupied from the boat as free and remove the pointers to them
     */
    private void freeCells(){
        if(this.shipModel.getCells()[0] != null) {
            for (Cell cell : this.shipModel.getCells()) {
                cell.free();
            }
            Arrays.fill(this.shipModel.getCells(), null);
        }
    }
    /**
     * Function to check if all the cells of the new position of a board are free and can be occupied
     * @param board board
     * @param x     x of the cell where the ship was originally placed
     * @param y     y of the cell where the ship was originally placed
     * @return if the ship can be placed
     */
    private boolean check(Board board, int x, int y){
        for (int i = 0; i < this.shipModel.getCells().length; i++) {
            if(this.checkCell(board, x, y, i))
                return false;
        }
        return true;
    }
    /**
     * Function to try to place the boat in a new position
     * @param board board
     * @param x     cell's x
     * @param y     cell's y
     * @return if it was placed or not
     */
    public boolean update(Board board, int x, int y){
        if(this.check(board, x, y)) {
            freeCells();
            this.shipModel.setX(x);
            this.shipModel.setY(y);
            for (int i = 0; i < this.shipModel.getCells().length; i++) {
                this.updateCell(board, i);
            }
            placed = true;
            return true;
        }
        return false;
    }
    /**
     * Function to check a cell of a board as occupied and assign it to the ship
     * @param board board
     * @param index cell index on the ship
     */
    void updateCell(Board board, int index){
        switch(this.shipModel.getWay()){
            case W:
                board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() + index].occupy(this.shipModel,index);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() + index];
                break;
            case N:
                board.getMatrix()[this.shipModel.getX() - index][this.shipModel.getY()].occupy(this.shipModel,index);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() - index][this.shipModel.getY()];
                break;
            case E:
                board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() - index].occupy(this.shipModel,index);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() - index];
                break;
            case S:
                board.getMatrix()[this.shipModel.getX() + index][this.shipModel.getY()].occupy(this.shipModel,index);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() + index][this.shipModel.getY()];
                break;
        }
    }
    /**
     * Function to check if a cell of a board is free and can be occupied
     * @param board board
     * @param x     cell X
     * @param y     cell Y
     * @param index cell index on the ship
     * @return  if the cell can be occupied or not
     */
    boolean checkCell(Board board, int x, int y, int index){
        try{
            switch (this.shipModel.getWay()) {
                case W:
                    if (board.getMatrix()[x][y + index].occupied(this.shipModel))
                        return true;
                    break;
                case N:
                    if (board.getMatrix()[x - index][y].occupied(this.shipModel))
                        return true;
                    break;
                case E:
                    if (board.getMatrix()[x][y - index].occupied(this.shipModel))
                        return true;
                    break;
                case S:
                    if (board.getMatrix()[x + index][y].occupied(this.shipModel))
                        return true;
                    break;
            }
        } catch(ArrayIndexOutOfBoundsException e){
            return true;
        }
        return false;
    }
    /**
     * Function to rotate the boat
     */
    public void rotate(){
        switch(this.shipModel.getWay()){
            case W:
                this.shipModel.setWay(Ship.Way.S);
                break;
            case S:
                this.shipModel.setWay(Ship.Way.E);
                break;
            case E:
                this.shipModel.setWay(Ship.Way.N);
                break;
            case N:
                this.shipModel.setWay(Ship.Way.W);
                break;
        }
    }
    /**
     * Function to check if all the cells are destroyed and check the boat as destroyed if so
     */
    public void check(){
        boolean destroy = true;
        for (Cell c : this.shipModel.getCells()){
            if(!c.check()){
                destroy = false;
                break;
            }
        }
        if(destroy)
            this.shipModel.destroy();
    }
    /**
     * Function to check if the boat was placed or not
     * @return  if it is placed
     */
    public boolean isPlaced(){
        return placed;
    }
}
