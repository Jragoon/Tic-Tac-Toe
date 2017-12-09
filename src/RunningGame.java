/*
    This class runs an instance of the GameSetup class. While GameSetup can technically
    accept any size 2d array, we'll be sticking with the classic 3x3 tic-tac-toe board.
    Author: Jared R. Taylor
    First version date: 12/9/17
 */
import java.util.Scanner;

public class RunningGame {
    public static void main(String[] args)
    {
        int[][] normalTicTacToeBoard = new int[3][3];
        GameSetup activeBoard = new GameSetup(normalTicTacToeBoard);

        System.out.println("Let the games begin!");
        activeBoard.displayBoard();

        int gameNumberOfTurns = 0;
        Scanner in = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver)
        {
            if (gameNumberOfTurns % 2 == 0)
            {
                System.out.print("Player one, make your move (Row): ");
                int playerRowChoice = in.nextInt();
                System.out.print("Player one, make your move (Column): ");
                String playerColumnChoice = in.next();
                activeBoard.assignPlayerOnePiece(playerRowChoice, playerColumnChoice);
                gameNumberOfTurns++;
                activeBoard.displayBoard();
                gameOver = activeBoard.checkForWinner();
            }
            else
            {
                System.out.print("Player two, make your move (Row): ");
                int playerRowChoice = in.nextInt();
                System.out.print("Player two, make your move (Column): ");
                String playerColumnChoice = in.next();
                activeBoard.assignPlayerTwoPiece(playerRowChoice, playerColumnChoice);
                gameNumberOfTurns++;
                activeBoard.displayBoard();
                gameOver = activeBoard.checkForWinner();
            }
        }
    }
}
