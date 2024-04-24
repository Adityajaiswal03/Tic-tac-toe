package models;

import exception.InvalidMoveException;
import stratergies.WinningAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState state;
    private Player winner;
    private int nextPlayerMoveIndex;
    private WinningAlgorithm winningAlgorithm;
    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = new ArrayList<>(players);
        this.state = GameState.INPROGRESS;
        this.nextPlayerMoveIndex = 0;
        this.moves = new ArrayList<>();
        this.winningAlgorithm = new WinningAlgorithm();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }
    public void printBoard(){
        this.board.printBoard();
    }
    private boolean isValid(Move move){
        // Check if the cell is empty
        // Check if the cell is within the board
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        if(row<0 || row>=board.getSize() || col<0 || col>=board.getSize()){
            return false;
        }
        return board.getBoard().get(row).get(col).getCellState().equals( CellState.EMPTY);
    }
    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        Move move = currentPlayer.makeMove(board);
        // Validate the move
        // If the move is invalid, ask the player to make the move again
        if(!isValid(move)){
           throw new InvalidMoveException("Invalid Move Made by"+currentPlayer.getName());
        }
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Cell cellToChange=board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.FILLED);
        Move finalMove= new Move(currentPlayer,cellToChange);
        moves.add(finalMove);
        nextPlayerMoveIndex=(nextPlayerMoveIndex+1)%players.size();
        if(board.isFull()){
            state=GameState.DRAW;
            winner=null;
        }
        if(winningAlgorithm.checkWinner(board,finalMove)){

                state=GameState.ENDED;
                winner=currentPlayer;


        }

    }



}
