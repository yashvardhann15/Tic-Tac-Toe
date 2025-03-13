package com.project.tictactoe.Strategy;

import com.project.tictactoe.Models.DifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotDifficultyStrategy(DifficultyLevel difficultyLevel) {
        if(difficultyLevel.equals(DifficultyLevel.EASY)) return new EasyBotPlayingStrategy();
        else if (difficultyLevel.equals(DifficultyLevel.HARD)) return new HardBotPlayingStrategy();
        else return new MediumBotPlayingStrategy();
    }
}
