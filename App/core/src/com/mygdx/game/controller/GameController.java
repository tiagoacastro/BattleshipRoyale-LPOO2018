package com.mygdx.game.controller;

import com.mygdx.game.model.Cell;

/**
 * Class in charge of the game, contains the user board and the bot board
 */
public class GameController {
    private static final int BOARD_SIZE = 10;
    private BoardController userBoard;
    private BoardController botBoard;
    private Cell chosen = null;
    private BotBehaviour behaviour;
    /**
     * GameController constructor that receives the user board created on the creatorScreen and creates the bot's
     * @param board     user's board
     */
    public GameController(BoardController board, BotBehaviour behaviour) {
        this.userBoard = board;

        this.behaviour = behaviour;

        this.botBoard = new BoardController(BOARD_SIZE);
    }
    /**
     * Getter for the bot's board
     * @return  bot's board
     */
    public BoardController getBotBoard() {
        return botBoard;
    }
    /**
     * Getter for the user's board
     * @return  user's board
     */
    public BoardController getUserBoard() {
        return userBoard;
    }
    /**
     * Function that a cell as the chosen one to, if the user desires, shoot
     * @param chosen    chosen cell
     */
    public void setChosen(Cell chosen) {
        this.chosen = chosen;
    }
    /**
     * Function to shoot the chosen cell (if it has been defined)
     */
    public void shoot() {
        if(this.chosen != null) {
            this.chosen.destroy();
            this.behaviour.shoot(this.userBoard);
            this.chosen = null;
        }
    }
}
