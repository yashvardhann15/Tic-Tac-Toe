package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.*;

import java.util.HashMap;

public class WinningRow implements WinningStrategy{
    HashMap<Integer , HashMap<Symbol , Integer>> rowCount;

    public WinningRow(){
        this.rowCount = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Moves move) {
        int dimension = board.getSize();
        int row = move.getCell().getRow();
        Symbol symbol = move.getCell().getSymbol();

        if(!rowCount.containsKey(row)){
            rowCount.put(row, new HashMap<>());
        }
        rowCount.get(row).put(symbol, rowCount.get(row).getOrDefault(symbol, 0) + 1);
        if(rowCount.get(row).get(symbol) == dimension){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Cell cell) {
        int row = cell.getRow();

        Symbol symbol = cell.getSymbol();
        int curCount = rowCount.get(row).get(symbol);
        rowCount.get(row).put(symbol, curCount - 1);
        return;
    }
}
