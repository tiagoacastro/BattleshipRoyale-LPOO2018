package com.mygdx.game.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class AITest {

    @Test(timeout=5000)
    public void EasyModeWin() {
        EasyBehaviour behaviour = new EasyBehaviour();

        BoardController board= new BoardController();

        board.populate();

        int cells = BoardController.getDimension() * BoardController.getDimension();
        for (int i = 0; i < cells; i++){
            behaviour.shoot(board);
        }

        assertTrue(board.check());
    }

    @Test(timeout=5000)
    public void HardModeWin() {
        HardBehaviour behaviour = new HardBehaviour();

        BoardController board= new BoardController();

        board.populate();

        int cells = 75;
        for (int i = 0; i < cells; i++){
            behaviour.shoot(board);
        }

        assertTrue(board.check());
    }

    @Test(timeout=5000)
    public void CrazyModeWin() {
        HardBehaviour behaviour = new HardBehaviour();

        BoardController board= new BoardController();

        board.populate();

        int cells = 75;
        for (int i = 0; i < cells; i++){
            behaviour.shoot(board);
        }

        assertTrue(board.check());
    }
}