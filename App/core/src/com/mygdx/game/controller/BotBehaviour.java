package com.mygdx.game.controller;

/**
 * bot behaviour interface (Strategy design Pattern)
 */
interface BotBehaviour {
    /**
     * Function to shoot the opponent's board based on AI
     */
    CellController shoot(BoardController board);
}
