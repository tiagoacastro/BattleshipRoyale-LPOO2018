package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Cruiser;
import com.mygdx.game.model.Ship;
import com.mygdx.game.model.Submarine;


import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

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
