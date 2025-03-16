package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.Board;
import com.project.tictactoe.Models.Cell;
import com.project.tictactoe.Models.Moves;
import com.project.tictactoe.Models.Player;

public class WinningDiagonal implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board , Moves move) {
        return false;
    }

    @Override
    public void handleUndo(Cell cell) {

    }
}
