package stratergies;

import models.Board;
import models.Move;

import java.util.HashMap;

public class WinningAlgorithm {
    HashMap<Integer,HashMap<Character,Integer>>rowMap=new HashMap<>();
    HashMap<Integer,HashMap<Character,Integer>>colMap=new HashMap<>();
    HashMap<Character,Integer>leftDiagonalMap=new HashMap<>();
    HashMap<Character,Integer>rightDiagonalMap=new HashMap<>();
    public boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol().getSymbol();

// Row check
        if (!rowMap.containsKey(row)) {
            rowMap.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currRow = rowMap.get(row);
        currRow.put(symbol, currRow.getOrDefault(symbol, 0) + 1);
        if (currRow.get(symbol) == board.getSize()) {
            return true;
        }

// Column check
        if (!colMap.containsKey(col)) {
            colMap.put(col, new HashMap<>());
        }
        HashMap<Character, Integer> currCol = colMap.get(col);
        currCol.put(symbol, currCol.getOrDefault(symbol, 0) + 1);
        if (currCol.get(symbol) == board.getSize()) {
            return true;
        }

// Diagonal check
        if (row == col) {
            leftDiagonalMap.put(symbol, leftDiagonalMap.getOrDefault(symbol, 0) + 1);
            if (leftDiagonalMap.get(symbol) == board.getSize()) {
                return true;
            }
        }

        if (row + col == board.getSize() - 1) {
            rightDiagonalMap.put(symbol, rightDiagonalMap.getOrDefault(symbol, 0) + 1);
            if (rightDiagonalMap.get(symbol) == board.getSize()) {
                return true;
            }
        }

        return false;

    }
}
