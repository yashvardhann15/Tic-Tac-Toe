package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.Board;
import com.project.tictactoe.Models.Moves;
import com.project.tictactoe.Models.Player;
import com.project.tictactoe.Models.Symbol;

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
}
