package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.Board;
import com.project.tictactoe.Models.Moves;
import com.project.tictactoe.Models.Player;
import com.project.tictactoe.Models.Symbol;

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
}
