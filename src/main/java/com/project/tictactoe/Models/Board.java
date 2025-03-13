package com.project.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {
    int size;
    List<List<Cell>> grid;

    public Board(int size){
        this.size = size;
        this.grid = new ArrayList<>();

        for(int i = 0; i < size; i++){
            grid.add(new ArrayList<>());
            for(int j = 0; j < size; j++){
                grid.get(i).add(new Cell(i , j));
            }
        }
    }

    public void display(){
        for(List<Cell> row : grid){
            for(Cell cell : row){
                cell.display();
            }
            System.out.println();
        }
    }
}
