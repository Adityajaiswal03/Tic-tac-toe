import controller.GameController;
import exception.InvalidMoveException;
import models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner sc=new Scanner(System.in);
        GameController gameController=new GameController();
        System.out.println("Please enter the dimension of the board :");
        int dimension=sc.nextInt();
        List<Player>players= List.of(
                new Player("Player1",new Symbol('X'), PlayerType.HUMAN),new Player("Player2",new Symbol('O'),PlayerType.HUMAN)
        );
        Game game=gameController.startGame(dimension,players);
//        gameController.printBaord(game);
        while (game.getState()== GameState.INPROGRESS){
            gameController.printBaord(game);
            gameController.makeMove(game);
        }

        if (gameController.checkGameState(game).equals(GameState.ENDED)) {
            gameController.printBaord(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");

        } else if(gameController.checkGameState(game).equals(GameState.DRAW)){
//            gameController.printBaord(game);

            System.out.println("Game DRAW");
        }


    }
}