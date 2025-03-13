package com.project.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private Symbol symbol;
    private CellState cellState;

    public Cell(int row , int col){
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
        this.symbol = null;
    }

    public void display(){
        if(this.cellState == CellState.EMPTY){
            System.out.print("| - |");
        }
        else {
            System.out.print("| " + this.symbol.getSymbol() + " |");
        }
    }
}
