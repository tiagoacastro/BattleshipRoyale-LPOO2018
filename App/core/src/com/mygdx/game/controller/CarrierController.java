package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Carrier;
import com.mygdx.game.model.Ship;

/**
 * CarrierController class created because of the differences needed in the methods related to the Carrier ship relating to the other ships
 */
public class CarrierController extends ShipController {
    /**
     * CarrierController construct that only calls the ShipController super constructor
     * @param ship  carrier model
     */
    CarrierController(Carrier ship) {
        super(ship);
    }
    /**
     * Function to check a cell of a board as occupied and assign it to the ship (Override for the Carrier ship)
     * @param board board
     * @param index cell index on the ship
     */
    @Override
    public void updateCell(Board board, int index){
        if(index != this.shipModel.getCells().length-1)
            super.updateCell(board, index);
        else
            switch (this.shipModel.getWay()) {
                case W:
                    board.getMatrix()[this.shipModel.getX() + 1][this.shipModel.getY() + (index - 1)].occupy(this,index);
                    this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() + 1][this.shipModel.getY() + (index - 1)];
                    break;
                case N:
                    board.getMatrix()[this.shipModel.getX() - (index - 1)][this.shipModel.getY() + 1].occupy(this,index);
                    this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() - (index - 1)][this.shipModel.getY() + 1];
                    break;
                case E:
                    board.getMatrix()[this.shipModel.getX() - 1][this.shipModel.getY() - (index - 1)].occupy(this,index);
                    this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() - 1][this.shipModel.getY() - (index - 1)];
                    break;
                case S:
                    board.getMatrix()[this.shipModel.getX() + (index - 1)][this.shipModel.getY() - 1].occupy(this,index);
                    this.shipModel.getCells()[index] = board.getMatrix()[this.shipModel.getX() + (index - 1)][this.shipModel.getY() - 1];
                    break;
            }
    }
    /**
     * Function to check if a cell of a board is free and can be occupied (Override for the Carrier ship)
     * @param board board
     * @param x     cell X
     * @param y     cell Y
     * @param index cell index on the ship
     * @return  if the cell can be occupied or not
     */
    @Override
    public boolean checkCell(Board board, int x, int y, int index){
        try{
            if(index != this.shipModel.getCells().length-1)
                return super.checkCell(board, x, y, index);
            else
                switch(this.shipModel.getWay()){
                    case W:
                        if(board.getMatrix()[x + 1][y + (index - 1)].occupied(this))
                            return true;
                        break;
                    case N:
                        if(board.getMatrix()[x - (index - 1)][y + 1].occupied(this))
                            return true;
                        break;
                    case E:
                        if(board.getMatrix()[x - 1][y - (index - 1)].occupied(this))
                            return true;
                        break;
                    case S:
                        if(board.getMatrix()[x + (index - 1)][y - 1].occupied(this))
                            return true;
                        break;
                }
        } catch(ArrayIndexOutOfBoundsException e){
            return true;
        }
        return false;
    }
}
