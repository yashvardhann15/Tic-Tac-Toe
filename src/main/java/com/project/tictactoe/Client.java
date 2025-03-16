package com.project.tictactoe;

import com.project.tictactoe.Controller.GameController;
import com.project.tictactoe.Models.*;
import com.project.tictactoe.Strategy.*;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();
        players.add(new Human(1, "Yashvardhan", new Symbol('X' , "red") , PlayerType.HUMAN));
//        players.add(new Bot(2 , "Bot" , new Symbol('O' , "blue") , PlayerType.BOT , DifficultyLevel.EASY));
        players.add(new Human(3, "Kushal", new Symbol('K' , "Green") , PlayerType.HUMAN));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new WinningDiagonal());
        winningStrategies.add(new WinningCorners());

        Game game = gameController.startGame(3 , players , winningStrategies);

        gameController.display(game);

        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.makeMove(game);
            gameController.display(game);
            gameController.Undo(game);
        }

        if(gameController.checkState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner is " + gameController.getWinner(game).getName());
        }
        else if(gameController.checkState(game).equals(GameState.DRAW)){
            System.out.println("Game Draw");
        }
    }
}
