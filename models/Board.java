package models;

import java.util.*;

public class Board {
    private int size;
    List<List<Cell>>board;

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public Board(int size) {
        this.size = size;
        board = new ArrayList<>();
        for(int i=0;i<size;i++){
            board.add(new ArrayList<Cell>());
            for(int j=0;j<size;j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getSize() {
        return size;
    }
    public boolean isFull(){
        for(List<Cell> row:board){
            for(Cell cell:row){
                if(cell.getCellState()==CellState.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
    public void printBoard() {
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    System.out.print("|-|");
                } else {

                    System.out.print("|" + cell.getPlayer().getSymbol().getSymbol() + "|");
                }
            }
            System.out.println();
        }
    }
}
