package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Ship;
import com.mygdx.game.model.Cell;

import java.util.Arrays;

/**
 * ShipController class
 */
public class ShipController {

    private Ship shipModel;

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
            if(!this.shipModel.check(board, x, y, i))                            //pode nao estar a usar o overriden method do carrier
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
                this.shipModel.updateCell(board, i);                        //pode nao estar a usar o overriden method do carrier
            }
        }
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
