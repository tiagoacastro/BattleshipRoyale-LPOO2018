package com.mygdx.game.model;

import java.util.Arrays;

/**
 * Carrier class - 5 cells in an L (Builder)
 */
public class Carrier extends Ship {
    private static final int size = 5;

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
                    board.getMatrix()[x + 1][y + (index - 1)].occupy(this);
                    cells[index] = board.getMatrix()[x + 1][y + (index - 1)];
                    break;
                case N:
                    board.getMatrix()[x - (index - 1)][y + 1].occupy(this);
                    cells[index] = board.getMatrix()[x - (index - 1)][y + 1];
                    break;
                case E:
                    board.getMatrix()[x - 1][y - (index - 1)].occupy(this);
                    cells[index] = board.getMatrix()[y - 1][x - (index - 1)];
                    break;
                case S:
                    board.getMatrix()[x + (index - 1)][y - 1].occupy(this);
                    cells[index] = board.getMatrix()[y + (index - 1)][x - 1];
                    break;
            }
    }

    @Override
    public boolean check(Board board, int x, int y, int index){
        try{
            if(index != size-1)
                return super.check(board, x, y, index);
            else
                switch(way){
                    case W:
                        if(board.getMatrix()[x + 1][y + (index - 1)].occupied(this))
                            return false;
                        break;
                    case N:
                        if(board.getMatrix()[x - (index - 1)][y + 1].occupied(this))
                            return false;
                        break;
                    case E:
                        if(board.getMatrix()[x - 1][y - (index - 1)].occupied(this))
                            return false;
                        break;
                    case S:
                        if(board.getMatrix()[x + (index - 1)][y - 1].occupied(this))
                            return false;
                        break;
                }
        } catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
}
