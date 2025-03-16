package com.project.tictactoe.Controller;

import com.project.tictactoe.Models.Game;
import com.project.tictactoe.Models.GameState;
import com.project.tictactoe.Models.Player;
import com.project.tictactoe.Strategy.WinningStrategy;

import java.util.List;

public class GameController {
    private Game game;
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        return Game.getBuilder().setDimension(dimension).setPlayers(players).setWinningStrategies(winningStrategies).build();
    }
    public void display(Game game){
        game.display();
    }
    public void makeMove(Game game){
        game.makeMove(game);
    }
    public GameState checkState(Game game){
        return game.getGameState();
    }
    public void Undo(Game game){
        game.Undo(game);
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
}
