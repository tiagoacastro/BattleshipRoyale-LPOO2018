package com.mygdx.game.controller;

public class GameController {
    private static final int BOARD_SIZE = 10;
    private BoardController userBoard;
    private BoardController botBoard;
    //private boolean myTurn = true;

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

    /*public boolean isMyTurn() {
        return myTurn;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }*/
}
