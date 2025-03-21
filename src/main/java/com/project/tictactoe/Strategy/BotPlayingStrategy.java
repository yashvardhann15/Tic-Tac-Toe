package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.Board;
import com.project.tictactoe.Models.Cell;
import com.project.tictactoe.Models.Moves;
import com.project.tictactoe.Models.Player;

public interface BotPlayingStrategy {
    public Moves makeMove(Board board, Player player);
}
