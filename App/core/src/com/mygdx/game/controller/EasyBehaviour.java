package com.mygdx.game.controller;

import java.util.Arrays;
import java.util.Random;

/**
 * bot behaviours implementing the BotBehaviour interface (Strategy design Pattern)
 */
public class EasyBehaviour implements BotBehaviour{
    boolean tracker[][] = new boolean[BoardController.getDimension()][BoardController.getDimension()];
    boolean boatDestroyed = false;
    /**
     * Behaviour constuctor, used to inicialize the tracker
     */
    public EasyBehaviour() {
        for (boolean[] row: tracker)
            Arrays.fill(row, false);
    }
    /**
     * Function to shoot the opponent's board based on AI (easy mode)
     * @param board board
     * @return the cell on which it hit or null if it missed a boat
     */
    @Override
    public CellController shoot(BoardController board) {
        Random rand = new Random();
        CellController chosen = null;
        boolean notChosen = true;

        while(notChosen) {
            int x = rand.nextInt(BoardController.getDimension());
            int y = rand.nextInt(BoardController.getDimension());

            chosen = board.getBoard().getMatrix()[x][y];

            if(!tracker[x][y]){
                tracker[x][y] = true;
                notChosen = false;
            }
        }

        if(chosen.destroy()) {
            if(chosen.getCellModel().getShip().getShipModel().check())
                boatDestroyed = true;
            return chosen;
        }

        return null;
    }
}