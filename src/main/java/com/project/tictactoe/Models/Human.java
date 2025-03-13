package com.project.tictactoe.Models;

import java.util.Scanner;

public class Human extends Player {
    public Human(long id, String name, Symbol symbol, PlayerType playerType) {
        super(id, name, symbol, playerType);
    }

    Scanner scanner = new Scanner(System.in);

    public boolean validate(int row, int col , Board board) {
        int dimension = board.getSize();
        if(row >= dimension || col >= dimension || row < 0 || col < 0) {
            return false;
        }
        return board.getGrid().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    @Override
    public Moves makeMove(Board board) {
        System.out.println("Choose a row");
        int row = scanner.nextInt();
        System.out.println("Choose a column");
        int col = scanner.nextInt();

        if(!validate(row , col , board)){
            System.out.println("Invalid row or column. Retry...");
            makeMove(board);
        }

        Moves move = new Moves(new Cell(row , col) , this);

        return move;
    }


}
