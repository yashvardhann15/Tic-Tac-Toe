package com.project.tictactoe.Models;

import com.project.tictactoe.Strategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Moves> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategy;
    private int filledCellsCount;

    private Game(Builder builder){
        int dimension = builder.dimension;
        Board board = new Board(dimension);
        this.board = board;
        this.players = builder.players;
        this.winningStrategy = builder.winningStrategies;
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.filledCellsCount = 0;
    }

    public void display(){
        this.board.display();
    }

    public boolean checkWinner(Moves move){
        boolean result = false;
        for(WinningStrategy strategy : winningStrategy){
            if(strategy.checkWinner(board , move)){
                result = true;
            }
        }
        return result;
    }

    public void makeMove(Game game){
        Player player = players.get(nextPlayerIndex);

        System.out.println("Its " + player.name + "'s turn");

        Moves move = player.makeMove(board);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = board.getGrid().get(row).get(col);

        cell.setSymbol(player.getSymbol());
        cell.setCellState(CellState.FILLED);

        nextPlayerIndex++;
        nextPlayerIndex %= players.size();

        move.setCell(cell);
        moves.add(move);

        filledCellsCount++;

        if(checkWinner(move)){
            game.setGameState(GameState.SUCCESS);
            setWinner(player);
//            System.out.println("Winner is " + winner.name);
        }
        else if(moves.size() == board.getSize() * board.getSize()){
                game.setGameState(GameState.DRAW);
        }
        else{
            game.setGameState(GameState.IN_PROGRESS);
        }
    }



    
    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public void validate(){
            int botCount = 0;
            for(Player player : players){
                if(player.playerType == PlayerType.BOT) botCount++;
            }
            if(botCount > 1) throw new RuntimeException("Invalid number of bots");

            if(players.size() != dimension - 1) throw new RuntimeException("Invalid number of players");

            Set<Symbol> s = new HashSet<>();
            for(Player player : players){
                s.add(player.getSymbol());
            }

            if(s.size() != players.size()) throw new RuntimeException("Two players can not have the same symbol");
        }

        public Game build(){

            validate();
            return new Game(this);
        }
    }
}
