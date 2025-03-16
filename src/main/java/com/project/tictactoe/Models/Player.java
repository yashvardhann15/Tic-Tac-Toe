package com.project.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {
    long id;
    String name;
    Symbol symbol;
    PlayerType playerType;
    int undoAvailable;

    public Player(long id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.undoAvailable = 1;
    }

    public abstract Moves makeMove(Board board);
}
