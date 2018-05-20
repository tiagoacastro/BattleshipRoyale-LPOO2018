package com.mygdx.game.model;

/**
 * Board class
 */
public class Board {
    private Cell matrix[][];

    public Board(int dimension) {
        matrix = new Cell[dimension][dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++){
                matrix[i][j] = new Cell(i, j);
            }
    }

    public Cell[][] getBoard() {
        return matrix;
    }
}
