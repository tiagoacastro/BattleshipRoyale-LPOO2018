package com.mygdx.game.controller;

import com.mygdx.game.model.Cell;
import com.mygdx.game.model.Ship;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * bot behaviours implementing the BotBehaviour interface (Strategy design Pattern)
 */
public class HardBehaviour extends EasyBehaviour{
    private ArrayList<Cell> discoverer = new ArrayList<Cell>();
    private int check = 0;
    /**
     * Behaviour constuctor, used to inicialize the tracker via super class
     */
    public HardBehaviour() {
        super();
    }
    /**
     * Function to shoot the opponent's board based on AI (hard mode)
     * @param board board
     * @return not used in this implementation, only on the easy mode
     */
    @Override
    public Cell shoot(BoardController board) {
        boatDestroyed = false;
        Cell chosen = null;

        switch(discoverer.size()){
            case 0:
                chosen = super.shoot(board);
                break;
            default:
                chosen = tryAround(board,  discoverer.get(discoverer.size()-1));
                break;
        }

        if(chosen != null){
            check = 0;
            discoverer.add(chosen);
            if(boatDestroyed){
                discoverer.clear();
            }
        }

        return chosen;
    }
    /**
     * Try to shoot cells around the first one to get the axis on wich the boat is positioned
     * @param board board
     * @return  the cell on which it hit or null if it missed a boat
     */
    private Cell tryAround(BoardController board, Cell c){
        switch(check){
            case 0:
                return shootSpecific(board, c.getX(),c.getY()+1, c);
            case 1:
                return shootSpecific(board, c.getX()-1,c.getY(), c);
            case 2:
                return shootSpecific(board, c.getX(),c.getY()-1, c);
            case 3:
                return shootSpecific(board, c.getX()+1,c.getY(), c);
            case 4:
                check = 0;
                return tryAround(board, discoverer.get(0));
        }

        return null;
    }
    /**
     * Try to shoot a certain cell
     * @param board board
     * @param x     cell x
     * @param y     cell y
     * @param cell  original cell for wich the surrounding cells are being checked
     * @return the cell on which it hit or null if it missed a boat
     */
    private Cell shootSpecific(BoardController board, int x, int y, Cell cell){
        try {
            check++;

            if (tracker[x][y]) {
                return tryAround(board, cell);
            }
            tracker[x][y] = true;

            Cell c = board.getBoard().getMatrix()[x][y];

            if (c.destroy()) {
                if (c.getShip().getShipModel().check())
                    boatDestroyed = true;
                return c;
            }

            return null;
        } catch(ArrayIndexOutOfBoundsException e){
            return tryAround(board, cell);
        }
    }
}