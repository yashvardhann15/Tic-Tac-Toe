package com.project.tictactoe.Models;

import com.project.tictactoe.Strategy.BotPlayingStrategy;
import com.project.tictactoe.Strategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    DifficultyLevel difficulty;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(long id, String name, Symbol symbol, PlayerType playerType, DifficultyLevel difficulty) {
        super(id, name, symbol, playerType);
        this.difficulty = difficulty;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotDifficultyStrategy(difficulty);
    }

    @Override
    public Moves makeMove(Board board) {

        return botPlayingStrategy.makeMove(board , this);
    }
}
