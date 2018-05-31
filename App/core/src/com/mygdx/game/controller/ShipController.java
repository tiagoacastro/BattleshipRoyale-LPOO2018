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
            for (CellController cell : this.shipModel.getCells()) {
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
                board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() + index].occupy(this,index);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() + index];
                break;
            case N:
                board.getMatrix()[this.shipModel.getX() - index][this.shipModel.getY()].occupy(this,index);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() - index][this.shipModel.getY()];
                break;
            case E:
                board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() - index].occupy(this,index);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() - index];
                break;
            case S:
                board.getMatrix()[this.shipModel.getX() + index][this.shipModel.getY()].occupy(this,index);
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
                    if (board.getMatrix()[x][y + index].occupied(this) || checkSurroundingCells(board, x, y + index))
                        return true;
                    break;
                case N:
                    if (board.getMatrix()[x - index][y].occupied(this) || checkSurroundingCells(board, x - index, y))
                        return true;
                    break;
                case E:
                    if (board.getMatrix()[x][y - index].occupied(this) || checkSurroundingCells(board, x, y - index))
                        return true;
                    break;
                case S:
                    if (board.getMatrix()[x + index][y].occupied(this) || checkSurroundingCells(board, x + index, y))
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
        for (CellController c : this.shipModel.getCells()){
            if(!c.getCellModel().check()){
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
    /**
     * Getter for the Ship model
     * @return  Ship model
     */
    public Ship getShipModel() {
        return shipModel;
    }
    /**
     * check if the surrounding cells are free
     * @param board board
     * @param x     cell X
     * @param y     cell Y
     * @return if the surrounding cells are free
     */
    private boolean checkSurroundingCells(Board board, int x, int y){
        return checkCell(board, x+1, y) || checkCell(board, x-1, y) ||
                checkCell(board, x, y+1) || checkCell(board, x, y-1);
    }
    /**
     * check if a cell is free
     * @param board board
     * @param x     cell X
     * @param y     cell Y
     * @return if a cell is free
     */
    private boolean checkCell(Board board, int x, int y){
        try{
            return board.getMatrix()[x][y].occupied(this);
        } catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    /**
     * set the way of the ship using an int from 1 to 4
     * @param rot   value
     */
    public void setWayByInt(int rot){
        switch(rot){
            case 0:
                this.shipModel.setWay(Ship.Way.W);
                break;
            case 1:
                this.shipModel.setWay(Ship.Way.S);
                break;
            case 2:
                this.shipModel.setWay(Ship.Way.E);
                break;
            case 3:
                this.shipModel.setWay(Ship.Way.N);
                break;
        }
    }
}
