package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.*;

import java.util.HashMap;

public class WinningColumn implements WinningStrategy{
    HashMap<Integer , HashMap<Symbol, Integer>> colCount;

    public WinningColumn(){
        this.colCount = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Board board, Moves move) {
        int dimension = board.getSize();
        int col = move.getCell().getCol();
        Symbol symbol = move.getCell().getSymbol();

        if(!colCount.containsKey(col)){
            colCount.put(col, new HashMap<>());
        }
        colCount.get(col).put(symbol, colCount.get(col).getOrDefault(symbol, 0) + 1);

        return colCount.get(col).get(symbol) == dimension;
    }

    @Override
    public void handleUndo(Cell cell) {
        int col = cell.getCol();

        Symbol symbol = cell.getSymbol();
        int curCount = colCount.get(col).get(symbol);
        colCount.get(col).put(symbol, curCount - 1);
        return;
    }
}
