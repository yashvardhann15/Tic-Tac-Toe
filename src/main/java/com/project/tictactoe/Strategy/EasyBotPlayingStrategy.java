package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Moves makeMove(Board board , Player player) {
        int dimension = board.getSize();
        for(List<Cell> cells : board.getGrid()){
            for(Cell cell : cells){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    cell.setSymbol(player.getSymbol());
                    cell.setCellState(CellState.FILLED);
                    return new Moves(cell , player);
                }
            }
        }
        return null;
    }
}
