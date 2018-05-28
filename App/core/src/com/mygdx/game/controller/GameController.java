package com.mygdx.game.controller;

import com.mygdx.game.model.Cell;

public class GameController {
    private static final int BOARD_SIZE = 10;
    private BoardController userBoard;
    private BoardController botBoard;
    private Cell chosen = null;

    public GameController(BoardController board) {
        this.userBoard = board;

        this.botBoard = new BoardController(BOARD_SIZE);
    }

    public BoardController getBotBoard() {
        return botBoard;
    }

    public BoardController getUserBoard() {
        return userBoard;
    }

    public void setChosen(Cell chosen) {
        this.chosen = chosen;
    }

    public void shoot() {
        if(this.chosen != null) {
            chosen.destroy();
            this.chosen = null;
        }
    }
}
