package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Ship;
import com.mygdx.game.model.Cell;

import java.util.Arrays;

/**
 * ShipController class
 */
public class ShipController {

    Ship shipModel;

    ShipController(Ship ship) {
        this.shipModel = ship;
    }

    private void freeCells(){
        if(this.shipModel.getCells()[0] != null) {
            for (Cell cell : this.shipModel.getCells()) {
                cell.free();
            }
            Arrays.fill(this.shipModel.getCells(), null);
        }
    }

    private boolean check(Board board, int x, int y){
        for (int i = 0; i < this.shipModel.getCells().length; i++) {
            if(this.checkCell(board, x, y, i))                            //pode nao estar a usar o overriden method do carrier
                return false;
        }
        return true;
    }

    public void update(Board board, int x, int y){
        if(this.check(board, x, y)) {
            freeCells();
            this.shipModel.setX(x);
            this.shipModel.setY(y);
            for (int i = 0; i < this.shipModel.getCells().length; i++) {
                this.updateCell(board, i);                        //pode nao estar a usar o overriden method do carrier
            }
        }
    }

    void updateCell(Board board, int index){
        switch(this.shipModel.getWay()){
            case W:
                board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() + index].occupy(this.shipModel);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() + index];
                break;
            case N:
                board.getMatrix()[this.shipModel.getX() - index][this.shipModel.getY()].occupy(this.shipModel);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() - index][this.shipModel.getY()];
                break;
            case E:
                board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() - index].occupy(this.shipModel);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX()][this.shipModel.getY() - index];
                break;
            case S:
                board.getMatrix()[this.shipModel.getX() + index][this.shipModel.getY()].occupy(this.shipModel);
                this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() + index][this.shipModel.getY()];
                break;
        }
    }

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

    public void revert(){
        switch(this.shipModel.getWay()){
            case W:
                this.shipModel.setWay(Ship.Way.N);
                break;
            case S:
                this.shipModel.setWay(Ship.Way.W);
                break;
            case E:
                this.shipModel.setWay(Ship.Way.S);
                break;
            case N:
                this.shipModel.setWay(Ship.Way.E);
                break;
        }
    }
}
