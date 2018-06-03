package com.mygdx.game.controller;

/**
 * bot behaviours implementing the BotBehaviour interface (Strategy design Pattern)
 */
public class CrazyBehaviour extends HardBehaviour{
    /**
     * Behaviour constuctor, used to inicialize the tracker via super class
     */
    public CrazyBehaviour() {
        super();
    }
    /**
     * Function to shoot the opponent's board based on AI (Crazy mode)
     * @param board board
     * @return not used in this implementation, only on the easy mode
     */
    @Override
    public CellController shoot(BoardController board) {
        super.shoot(board);
        if(!board.check())
            super.shoot(board);
        return null;
    }
}