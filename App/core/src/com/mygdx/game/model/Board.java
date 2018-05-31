package com.mygdx.game.model;

import com.mygdx.game.controller.BoardController;
import com.mygdx.game.controller.CellController;

/**
 * Board class
 */
public class Board {
    private CellController matrix[][];

    public Board(int dimension, BoardController board) {
        matrix = new CellController[dimension][dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++){
                matrix[i][j] = new CellController(new Cell(i, j, board));
            }
    }

    public CellController[][] getMatrix() {
        return matrix;
    }
}
