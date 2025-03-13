package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.Board;
import com.project.tictactoe.Models.Moves;
import com.project.tictactoe.Models.Player;

public class WinningCorners implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board , Moves move) {
        return false;
    }
}
