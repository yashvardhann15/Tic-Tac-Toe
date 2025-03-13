package com.project.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol {
    private char symbol;
    private String color;

    public Symbol(char symbol, String color) {
        this.symbol = symbol;
        this.color = color;
    }
}
