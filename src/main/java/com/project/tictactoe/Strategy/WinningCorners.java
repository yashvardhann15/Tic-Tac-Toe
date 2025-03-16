package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.*;

public class WinningCorners implements WinningStrategy{
    Symbol topLeftCorner;
    Symbol topRightCorner;
    Symbol bottomLeftCorner;
    Symbol bottomRightCorner;
    int dimension;

    public WinningCorners() {
        this.topLeftCorner = null;
        this.topRightCorner = null;
        this.bottomLeftCorner = null;
        this.bottomRightCorner = null;
    }

    @Override
    public boolean checkWinner(Board board , Moves move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        int dimension = board.getSize();
        this.dimension = dimension;

        if(row == 0 && col == 0) {
            topLeftCorner = move.getCell().getSymbol();
        }
        else if(row == dimension - 1 && col == 0) {
            bottomLeftCorner = move.getCell().getSymbol();
        }
        else if(row == 0 && col == dimension - 1) {
            topRightCorner = move.getCell().getSymbol();
        }
        else if(row == dimension - 1 && col == dimension - 1){
            bottomRightCorner = move.getCell().getSymbol();
        }

        if (topLeftCorner == null || topRightCorner == null || bottomLeftCorner == null || bottomRightCorner == null) {
            return false;
        }

        return topLeftCorner.equals(topRightCorner) &&
                bottomLeftCorner.equals(bottomRightCorner) &&
                bottomRightCorner.equals(topRightCorner);
    }

    @Override
    public void handleUndo(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        if(row == 0 && col == 0) {
            topLeftCorner = null;
        }
        else if(row == dimension - 1 && col == 0) {
            bottomLeftCorner = null;
        }
        else if(row == 0 && col == dimension - 1) {
            topRightCorner = null;
        }
        else if(row == dimension - 1 && col == dimension - 1) {
            bottomRightCorner = null;
        }
    }
}
