package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Cruiser;
import com.mygdx.game.model.Ship;
import com.mygdx.game.model.Submarine;

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


    @Test
    public void overPutShips() {

        BoardController boardC = new BoardController();

        Board board = new Board(10,boardC);
        Ship submarine = new Submarine();
        ShipController shipC = new ShipController(submarine);

        Ship cruiser = new Cruiser();
        ShipController shipC2 = new ShipController(cruiser);


        assertFalse (shipC.isPlaced());
        assertFalse (shipC2.isPlaced());

        shipC.update(board, 5,5);

        assertTrue(shipC.isPlaced());

        shipC2.update(board, 5,5);

        assertFalse (shipC2.isPlaced());

    }

    @Test
    public void rotateAndPutShip() {
        //Tests if it possible to rotate and put the ship in the board

        BoardController boardC = new BoardController();

        Board board = new Board(10,boardC);
        Ship submarine = new Submarine();
        ShipController shipC = new ShipController(submarine);

        assertFalse (shipC.isPlaced());

        shipC.rotate();
        shipC.update(board, 5,5);

        assertTrue(shipC.isPlaced());
        assertEquals(board.getMatrix()[5][5].getCellModel().getShip(),shipC);
        assertEquals(board.getMatrix()[6][5].getCellModel().getShip(),shipC);
        assertEquals(board.getMatrix()[7][5].getCellModel().getShip(),shipC);
    }

    @Test
    public void shootShipDown() {

        BoardController boardC = new BoardController();

        Board board = new Board(10, boardC);
        Ship submarine = new Submarine();
        ShipController shipC = new ShipController(submarine);

        shipC.update(board, 5,5);
        assertTrue(shipC.isPlaced());

        board.getMatrix()[5][5].destroy(false);
        board.getMatrix()[5][6].destroy(false);
        board.getMatrix()[5][7].destroy(false);

        assertTrue(submarine.check());

    }

    @Test
    public void failInsertionBecauseDirectionAndIndex() {

        BoardController boardC = new BoardController();

        Board board = new Board(10, boardC);
        Ship submarine = new Submarine();
        ShipController shipC = new ShipController(submarine);

        assertFalse (shipC.isPlaced());

        shipC.rotate();
        shipC.rotate();
        shipC.rotate();
        shipC.update(board,1,1);

        assertFalse (shipC.isPlaced());

        shipC.update(board,11,11);

        assertFalse (shipC.isPlaced());


    }
}