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

        BoardController hBoard= new BoardController();
        BoardController eBoard= new BoardController();

        hBoard.populate();
        eBoard.populate();

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

    @Test(timeout=5000)
    public void CrazyVSEasy() {
        CrazyBehaviour cBehaviour = new CrazyBehaviour();
        EasyBehaviour eBehaviour = new EasyBehaviour();

        BoardController cBoard= new BoardController();
        BoardController eBoard= new BoardController();

        cBoard.populate();
        eBoard.populate();

        int cells = BoardController.getDimension() * BoardController.getDimension();
        for (int i = 0; i < cells; i++){
            cBehaviour.shoot(eBoard);
            eBehaviour.shoot(cBoard);

            if(eBoard.check() || cBoard.check())
                break;
        }

        assertTrue(eBoard.check());
        assertFalse(cBoard.check());
    }

    @Test(timeout=5000)
    public void CrazyVSHard() {
        CrazyBehaviour cBehaviour = new CrazyBehaviour();
        HardBehaviour hBehaviour = new HardBehaviour();

        BoardController cBoard= new BoardController();
        BoardController hBoard= new BoardController();

        cBoard.populate();
        hBoard.populate();

        int cells = BoardController.getDimension() * BoardController.getDimension();
        for (int i = 0; i < cells; i++){
            cBehaviour.shoot(hBoard);
            hBehaviour.shoot(cBoard);

            if(hBoard.check() || cBoard.check())
                break;
        }

        assertTrue(hBoard.check());
        assertFalse(cBoard.check());
    }


}