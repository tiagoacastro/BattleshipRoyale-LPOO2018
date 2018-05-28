package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Carrier;
import com.mygdx.game.model.Cruiser;
import com.mygdx.game.model.Dreadnought;
import com.mygdx.game.model.PatrolBoat;
import com.mygdx.game.model.Submarine;
import java.util.Random;

/**
 * Class containing the player's board
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

    public enum Ships{carrier, cruiser, dreadnought, submarine, patrolBoat}

    public BoardController(int dimension) {
        this.board = new Board(dimension, this);
        this.dimension = dimension;
    }

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

    public ShipController getChosen() {
        return chosen;
    }

    public Board getBoard() {
        return board;
    }

    public boolean allPlaced(){
        return carrier.isPlaced() && dreadnought.isPlaced() && submarine.isPlaced() && cruiser.isPlaced() && patrolBoat.isPlaced();
    }

    public void populate(){
        place(carrier);
        place(dreadnought);
        place(submarine);
        place(cruiser);
        place(patrolBoat);
    }

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
