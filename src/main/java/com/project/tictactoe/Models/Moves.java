package com.project.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Moves {
    Cell cell;
    Player player;

    public Moves(Cell cell, Player player){
        this.cell = cell;
        this.player = player;
    }
}
