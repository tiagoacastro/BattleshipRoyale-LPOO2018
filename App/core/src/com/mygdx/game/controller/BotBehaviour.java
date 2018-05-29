package com.mygdx.game.controller;

import com.mygdx.game.model.Cell;

/**
 * bot behaviour interface (Strategy design Pattern)
 */
interface BotBehaviour {
    /**
     * Function to shoot the opponent's board based on AI
     */
    Cell shoot(BoardController board);
}
