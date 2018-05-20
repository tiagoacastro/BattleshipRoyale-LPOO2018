package com.mygdx.game.controller;

import com.mygdx.game.model.Board;
import com.mygdx.game.model.Carrier;
import com.mygdx.game.model.Cruiser;
import com.mygdx.game.model.Dreadnought;
import com.mygdx.game.model.PatrolBoat;
import com.mygdx.game.model.Submarine;

/**
 * Class containing the player's board
 */
public class BoardController {
    private Board board;
    private ShipController carrier = new ShipController(new Carrier());
    private ShipController cruiser = new ShipController(new Cruiser());
    private ShipController dreadnought = new ShipController(new Dreadnought());
    private ShipController submarine = new ShipController(new Submarine());
    private ShipController patrolBoat = new ShipController(new PatrolBoat());
    private ShipController chosen = null;

    public enum Ships{carrier, cruiser, dreadnought, submarine, patrolBoat}

    public BoardController(int dimension) {
        this.board = new Board(dimension);
    }

    public void setChosen(Ships choice) {
        if(this.chosen == null)
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


}
