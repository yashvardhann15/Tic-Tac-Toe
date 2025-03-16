package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.Board;
import com.project.tictactoe.Models.Cell;
import com.project.tictactoe.Models.Moves;
import com.project.tictactoe.Models.Player;

public interface WinningStrategy {
    public boolean checkWinner(Board board , Moves move);
    public void handleUndo(Cell cell);
}
