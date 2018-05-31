package com.mygdx.game.controller;

import com.mygdx.game.model.Cell;
import java.util.ArrayList;

/**
 * bot behaviours implementing the BotBehaviour interface (Strategy design Pattern)
 */
public class HardBehaviour extends EasyBehaviour{
    private ArrayList<Cell> discoverer = new ArrayList<Cell>();
    private int way = 0;
    private Cell edgeCell = null;
    private boolean trySide = true;
    private boolean switchSide = true;
    private boolean tailStart = false;
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
        Cell chosen;

        switch(discoverer.size()){
            case 0:
                chosen = super.shoot(board);
                break;
            case 1:
                chosen = tryAround(board, discoverer.get(discoverer.size()-1));
                break;
            case 4:
                if(tailStart)
                    chosen = tryFollow(board, discoverer.get(discoverer.size()-1), true);
                else
                    chosen = tryCarrier(board);
                break;
            default:
                chosen = tryFollow(board, discoverer.get(discoverer.size()-1), true);
                break;
        }

        if(chosen != null){
            discoverer.add(chosen);
            if(boatDestroyed){
                way = 0;
                switchSide = true;
                tailStart = false;
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
        switch(way){
            case 0:
                return shootSpecificAround(board, c.getX(),c.getY()+1, c);
            case 1:
                return shootSpecificAround(board, c.getX()-1,c.getY(), c);
            case 2:
                return shootSpecificAround(board, c.getX(),c.getY()-1, c);
            case 3:
                return shootSpecificAround(board, c.getX()+1,c.getY(), c);
        }

        return null;
    }
    /**
     * Try to shoot a certain cell (around mode)
     * @param board board
     * @param x     cell x
     * @param y     cell y
     * @param cell  original cell for wich the surrounding cells are being checked
     * @return the cell on which it hit or null if it missed a boat
     */
    private Cell shootSpecificAround(BoardController board, int x, int y, Cell cell){
        try {
            if (tracker[x][y]) {
                way++;
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
            way++;
            return tryAround(board, cell);
        }
    }
    /**
     * Try to shoot cells in the same direction as the last one
     * @param board board
     * @return the cell on which it hit or null if it missed a boat
     */
    private Cell tryFollow(BoardController board, Cell c, boolean notCarrier){
        switch(way){
            case 0:
                return shootSpecificFollow(board, c.getX(),c.getY()+1, c, notCarrier);
            case 1:
                return shootSpecificFollow(board, c.getX()-1,c.getY(), c, notCarrier);
            case 2:
                return shootSpecificFollow(board, c.getX(),c.getY()-1, c, notCarrier);
            case 3:
                return shootSpecificFollow(board, c.getX()+1,c.getY(), c, notCarrier);
        }

        return null;
    }
    /**
     * Try to shoot a certain cell (follow mode)
     * @param board board
     * @param x     cell x
     * @param y     cell y
     * @param cell  original cell for wich the next cell is being checked
     * @return the cell on which it hit or null if it missed a boat
     */
    private Cell shootSpecificFollow(BoardController board, int x, int y, Cell cell, boolean notCarrier){
        try {
            if (tracker[x][y]) {
                if(notCarrier) {
                    if(switchSide) {
                        way += 2;
                        way %= 4;
                        edgeCell = cell;
                        switchSide = false;
                        return tryFollow(board, discoverer.get(0), true);
                    } else {
                        tailStart = true;
                        return tryCarrier(board);
                    }
                } else {
                    return tryCarrier(board);
                }
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
            if(notCarrier) {
                if(switchSide) {
                    way += 2;
                    way %= 4;
                    edgeCell = cell;
                    switchSide = false;
                    return tryFollow(board, discoverer.get(0), true);
                } else {
                    tailStart = true;
                    return tryCarrier(board);
                }
            } else {
                return tryCarrier(board);
            }
        }
    }

    /**
     * Try to take down the carrier (only gets called when 4 cells have been destroyed and the ship hasn't gone down)
     * @param board board
     * @return  the cell on which it hit or null if it missed a boat
     */
    private Cell tryCarrier(BoardController board){
        if (trySide) {
            way += 1;
            if(!tailStart)
                way += 2;
            way %= 4;
            trySide = false;
            if(!tailStart)
                return tryFollow(board, discoverer.get(discoverer.size() - 1), false);
            else
                return tryFollow(board, discoverer.get(0), false);
        } else {
            way += 2;
            way %= 4;
            return tryFollow(board, edgeCell, false);
        }
    }
}