package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Carrier;
import com.mygdx.game.model.Cruiser;
import com.mygdx.game.model.Dreadnought;
import com.mygdx.game.model.PatrolBoat;
import com.mygdx.game.model.Submarine;
import java.util.Random;

/**
 * Class containing the player's board in charge of every operation on it
 */
public class BoardController {
    private Board board;
    private int dimension;
    private CarrierController carrier = new CarrierController(new Carrier());
    private ShipController dreadnought = new ShipController(new Dreadnought());
    private ShipController submarine = new ShipController(new Submarine());
    private ShipController cruiser = new ShipController(new Cruiser());
    private ShipController patrolBoat = new ShipController(new PatrolBoat());
    private ShipController chosen = null;
    /**
     * Enum with the ship types
     */
    public enum Ships{carrier, cruiser, dreadnought, submarine, patrolBoat}
    /**
     * BoardController constructor that receives the board's dimension and creates it
     * @param dimension     dimension of the board
     */
    public BoardController(int dimension) {
        this.board = new Board(dimension, this);
        this.dimension = dimension;
    }
    /**
     * Setter for the chosen ship to place
     * @param choice        ship name
     */
    public void setChosen(Ships choice) {
        switch(choice){
            case carrier:
                this.chosen = this.carrier;
                break;
            case cruiser:
                this.chosen = this.cruiser;
                break;
            case dreadnought:
                this.chosen = this.dreadnought;
                break;
            case submarine:
                this.chosen = this.submarine;
                break;
            case patrolBoat:
                this.chosen = this.patrolBoat;
                break;
        }
    }
    /**
     * Getter for the chosen ship to place
     * @return chosen ship
     */
    public ShipController getChosen() {
        return chosen;
    }
    /**
     * Getter for the Board model
     * @return board
     */
    public Board getBoard() {
        return board;
    }
    /**
     * Function to check if all the boats have been placed
     * @return if all the boats have been placed
     */
    public boolean allPlaced(){
        return carrier.isPlaced() && dreadnought.isPlaced() && submarine.isPlaced() && cruiser.isPlaced() && patrolBoat.isPlaced();
    }
    /**
     * Function that randomly places all boats
     */
    public void populate(){
        place(carrier);
        place(dreadnought);
        place(submarine);
        place(cruiser);
        place(patrolBoat);
    }
    /**
     * Function to randomly place a single boat
     * @param ship  boat to be placed
     */
    private void place(ShipController ship){
        Random rand = new Random();

        boolean notPlaced = true;
        while(notPlaced) {
            int x = rand.nextInt(dimension);
            int y = rand.nextInt(dimension);

            if(ship.update(this.board, x, y))
                notPlaced = false;
        }
    }
}
