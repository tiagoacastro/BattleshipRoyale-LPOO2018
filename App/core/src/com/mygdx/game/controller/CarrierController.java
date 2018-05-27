package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Ship;

public class CarrierController extends ShipController {

    CarrierController(Ship ship) {
        super(ship);
    }

    @Override
    public void updateCell(Board board, int index){
        if(index != this.shipModel.getCells().length-1)
            super.updateCell(board, index);
        else
            switch (this.shipModel.getWay()) {
                case W:
                    board.getMatrix()[this.shipModel.getX() + 1][this.shipModel.getY() + (index - 1)].occupy(this.shipModel);
                    this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() + 1][this.shipModel.getY() + (index - 1)];
                    break;
                case N:
                    board.getMatrix()[this.shipModel.getX() - (index - 1)][this.shipModel.getY() + 1].occupy(this.shipModel);
                    this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() - (index - 1)][this.shipModel.getY() + 1];
                    break;
                case E:
                    board.getMatrix()[this.shipModel.getX() - 1][this.shipModel.getY() - (index - 1)].occupy(this.shipModel);
                    this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() - 1][this.shipModel.getY() - (index - 1)];
                    break;
                case S:
                    board.getMatrix()[this.shipModel.getX() + (index - 1)][this.shipModel.getY() - 1].occupy(this.shipModel);
                    this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() + (index - 1)][this.shipModel.getY() - 1];
                    break;
            }
    }

    @Override
    public boolean checkCell(Board board, int x, int y, int index){
        try{
            if(index != this.shipModel.getCells().length-1)
                return super.checkCell(board, x, y, index);
            else
                switch(this.shipModel.getWay()){
                    case W:
                        if(board.getMatrix()[x + 1][y + (index - 1)].occupied(this.shipModel))
                            return true;
                        break;
                    case N:
                        if(board.getMatrix()[x - (index - 1)][y + 1].occupied(this.shipModel))
                            return true;
                        break;
                    case E:
                        if(board.getMatrix()[x - 1][y - (index - 1)].occupied(this.shipModel))
                            return true;
                        break;
                    case S:
                        if(board.getMatrix()[x + (index - 1)][y - 1].occupied(this.shipModel))
                            return true;
                        break;
                }
        } catch(ArrayIndexOutOfBoundsException e){
            return true;
        }
        return false;
    }
}
