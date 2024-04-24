package models;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Player{
    private String Name;
    private Symbol symbol;
    private PlayerType playerType;
    private static Scanner sc = new Scanner(System.in);
    public Player(String name, Symbol c, PlayerType p) {
        Name = name;
        this.symbol = c;
        this.playerType = p;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol c) {
        this.symbol = c;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType p) {
        this.playerType = p;
    }
    public Move makeMove(Board board){
        // Ask the player where to make the move
        System.out.println("Enter the row to make the move");
        int row = sc.nextInt();
        System.out.println("Enter the column to make the move");
        int col = sc.nextInt();

        return new Move( this,new Cell(row, col));
    }


}