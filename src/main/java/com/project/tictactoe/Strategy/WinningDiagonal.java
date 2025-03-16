package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.*;

import java.util.HashMap;

public class WinningDiagonal implements WinningStrategy{

    HashMap<Symbol, Integer> diagonal1Count;
    HashMap<Symbol, Integer> diagonal2Count;
    int dimension;

    public WinningDiagonal() {
        diagonal1Count = new HashMap<>();
        diagonal2Count = new HashMap<>();

    }

    @Override
    public boolean checkWinner(Board board , Moves move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        int dimension = board.getSize();
        this.dimension = dimension;


//        System.out.println("Dimension: " + dimension);

        if(row == col){
            if(!diagonal1Count.containsKey(move.getCell().getSymbol())){
                diagonal1Count.put(move.getCell().getSymbol(), 0);
            }

            diagonal1Count.put(move.getCell().getSymbol() , diagonal1Count.get(move.getCell().getSymbol()) + 1);


//            System.out.println("Diagonal1 symbol count: " + move.getCell().getSymbol().getSymbol() + " " + diagonal1Count.get(move.getCell().getSymbol()));
            if(diagonal1Count.get(move.getCell().getSymbol()) == dimension){
                return true;
            }

        }
        else if(row + col == dimension - 1){
            if(!diagonal2Count.containsKey(move.getCell().getSymbol())) {
                diagonal2Count.put(move.getCell().getSymbol(), 0);
            }
            diagonal2Count.put(move.getCell().getSymbol() , diagonal2Count.get(move.getCell().getSymbol()) + 1);


//            System.out.println("Diagonal2 symbol count: " + move.getCell().getSymbol().getSymbol() + " " + diagonal2Count.get(move.getCell().getSymbol()));
            if(diagonal2Count.get(move.getCell().getSymbol()) == dimension) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void handleUndo(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        if(row == col){
            diagonal1Count.put(cell.getSymbol(), diagonal1Count.get(cell.getSymbol()) - 1);
//            System.out.println("count after removing " + cell.getSymbol().getSymbol() + " " + diagonal1Count.get(cell.getSymbol()));
        }
        else if(row + col == dimension - 1){
            diagonal2Count.put(cell.getSymbol(), diagonal2Count.get(cell.getSymbol()) - 1);
//            System.out.println("count after removing " + cell.getSymbol().getSymbol() + " " + diagonal2Count.get(cell.getSymbol()));
        }
    }
}
