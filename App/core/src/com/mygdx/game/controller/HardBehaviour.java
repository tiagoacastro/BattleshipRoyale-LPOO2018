package com.mygdx.game.controller;

import com.mygdx.game.model.Cell;
import java.util.ArrayList;
import java.util.Random;

/**
 * bot behaviours implementing the BotBehaviour interface (Strategy design Pattern)
 */
public class HardBehaviour extends EasyBehaviour implements BotBehaviour{
    private ArrayList<Cell> discoverer = new ArrayList<Cell>();
    /**
     * Function to shoot the opponent's board based on AI
     */
    @Override
    public Cell shoot(BoardController board) {
        boatDestroyed = false;
        Cell chosen = null;

        switch(discoverer.size()){
            case 0:
                chosen = super.shoot(board);
                break;
            case 1:

                break;
        }

        if(chosen != null){
            discoverer.add(chosen);
            if(boatDestroyed){
                discoverer.clear();
            }
        }

        return chosen;
    }
}