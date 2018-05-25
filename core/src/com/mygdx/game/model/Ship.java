package com.mygdx.game.model;

/**
 * Ship super class (Template)
 */
public abstract class Ship{
    protected int x = -1;
    protected int y = -1;
    Way way = Way.W;
    private boolean destroyed = false;
    Cell cells[];

    public enum Way{W, S, E, N}

    Ship(){}

    public void updateCell(Board board, int index){
        switch(way){
            case W:
                board.getMatrix()[x + index][y].occupy(this);
                cells[index] = board.getMatrix()[x + index][y];
                break;
            case S:
                board.getMatrix()[x][y - index].occupy(this);
                cells[index] = board.getMatrix()[x][y - index];
                break;
            case E:
                board.getMatrix()[x - index][y].occupy(this);
                cells[index] = board.getMatrix()[x - index][y];
                break;
            case N:
                board.getMatrix()[x][y + index].occupy(this);
                cells[index] = board.getMatrix()[x][y + index];
                break;
        }
    }

    public void destroy(){
        destroyed = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Way getWay() {
        return way;
    }

    public void setWay(Way way) {
        this.way = way;
    }

    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    public boolean check(){
        return destroyed;
    }
}
