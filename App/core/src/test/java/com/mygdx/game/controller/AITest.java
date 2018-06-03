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

            if(board.check())
                break;
        }

        assertTrue(board.check());
    }

    @Test(timeout=5000)
    public void HardModeWin() {
        HardBehaviour behaviour = new HardBehaviour();

        BoardController board= new BoardController();

        board.populate();

        int cells = BoardController.getDimension() * BoardController.getDimension();
        for (int i = 0; i < cells; i++){
            behaviour.shoot(board);

            if(board.check())
                break;
        }

        assertTrue(board.check());
    }

    @Test(timeout=5000)
    public void CrazyModeWin() {
        HardBehaviour behaviour = new HardBehaviour();

        BoardController board= new BoardController();

        board.populate();

        int cells = BoardController.getDimension() * BoardController.getDimension();
        for (int i = 0; i < cells; i++){
            behaviour.shoot(board);

            if(board.check())
                break;
        }

        assertTrue(board.check());
    }

    @Test(timeout=5000)
    public void HardVSEasy() {
        HardBehaviour hBehaviour = new HardBehaviour();
        EasyBehaviour eBehaviour = new EasyBehaviour();

        BoardController eBoard= new BoardController();
        BoardController hBoard= new BoardController();

        eBoard.populate();
        hBoard.populate();

        int cells = BoardController.getDimension() * BoardController.getDimension();
        for (int i = 0; i < cells; i++){
            hBehaviour.shoot(eBoard);
            eBehaviour.shoot(hBoard);

            if(hBoard.check() || eBoard.check())
                break;
        }

        assertTrue(eBoard.check());
        assertFalse(hBoard.check());
    }
}