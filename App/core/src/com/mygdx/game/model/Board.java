package com.mygdx.game.model;

import com.mygdx.game.controller.BoardController;

/**
 * Board class
 */
public class Board {
    private Cell matrix[][];

    public Board(int dimension, BoardController board) {
        matrix = new Cell[dimension][dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++){
                matrix[i][j] = new Cell(i, j, board);
            }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }
}
