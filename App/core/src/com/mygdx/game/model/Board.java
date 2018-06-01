package com.mygdx.game.model;

import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.CellController;

/**
 * Board class
 */
public class Board {
    private CellController matrix[][];
    /**
     * Board constructor
     * @param dimension board dimension (square)
     * @param board board controller
     */
    public Board(int dimension, BoardController board) {
        matrix = new CellController[dimension][dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++){
                matrix[i][j] = new CellController(new Cell(i, j, board));
            }
    }
    /**
     * Getter for the cell matrix
     * @return  matrix
     */
    public CellController[][] getMatrix() {
        return matrix;
    }
}
