package com.mygdx.game.controller;

import com.mygdx.game.model.Cell;
import java.util.ArrayList;
import java.util.Random;

/**
 * bot behaviours implementing the BotBehaviour interface (Strategy design Pattern)
 */
public class EasyBehaviour implements BotBehaviour{
    ArrayList<Cell> tracker = new ArrayList<Cell>();
    boolean boatDestroyed = false;
    /**
     * Function to shoot the opponent's board based on AI
     */
    @Override
    public Cell shoot(BoardController board) {
        Random rand = new Random();
        Cell chosen = null;
        boolean notChosen = true;

        while(notChosen) {
            int x = rand.nextInt(board.getDimension());
            int y = rand.nextInt(board.getDimension());

            chosen = board.getBoard().getMatrix()[x][y];
            boolean repeated = false;

            for (Cell c : tracker) {
                if (c == chosen){
                    repeated = true;
                    break;
                }
            }

            if(!repeated)
                notChosen = false;
        }

        tracker.add(chosen);

        if(chosen.destroy()) {
            boatDestroyed = true;
            return chosen;
        }

        return null;
    }
}