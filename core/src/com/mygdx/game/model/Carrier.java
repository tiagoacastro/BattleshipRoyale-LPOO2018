package com.mygdx.game.model;

import java.util.Arrays;

/**
 * Carrier class - 4 cells in an L (Builder)
 */
public class Carrier extends Ship {
    private static final int size = 4;

    public Carrier() {
        super();
        cells = new Cell[size];
        Arrays.fill(cells, null);
    }

    @Override
    public void updateCell(Board board, int index){
        if(index != size-1)
            super.updateCell(board, index);
        else
            switch (way) {
                case W:
                    board.getMatrix()[x + (index - 1)][y + 1].occupy(this);
                    cells[index] = board.getMatrix()[x + (index - 1)][y + 1];
                    break;
                case S:
                    board.getMatrix()[x + 1][y - (index - 1)].occupy(this);
                    cells[index] = board.getMatrix()[x + 1][y - (index - 1)];
                    break;
                case E:
                    board.getMatrix()[x - (index - 1)][y - 1].occupy(this);
                    cells[index] = board.getMatrix()[x - (index - 1)][y - 1];
                    break;
                case N:
                    board.getMatrix()[x - 1][y + (index - 1)].occupy(this);
                    cells[index] = board.getMatrix()[x - 1][y + (index - 1)];
                    break;
            }
    }
}
