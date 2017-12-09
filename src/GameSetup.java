/*
    You can construct an instance of this class using any 2D array- however it is setup to only handle 3x3
    boards. Currently, the class uses the "checkForWinner" method. The "checkForWinner" does not currently
    use loops to count sums for rows and columns- currently, the method figures the winner
    by counting positions entered manually, and can not be scaled for larger 2D arrays.
    Author: Jared R. Taylor
    First version: 12/9/17
 */


public class GameSetup {

    private int[][] gameBoard = new int[2][2];

    public GameSetup(int[][] aGameBoard)
    {
        gameBoard = aGameBoard;
    }

    public void displayBoard()
    {
        int currentRow = 1;
        System.out.println("Current Game:");
        System.out.println("    A | B | C ");
        for (int i = 0; i < gameBoard.length; i++)
        {
            for (int j = 0; j < gameBoard[i].length; j++)
            {
                if(j == 0)
                {
                    System.out.print(currentRow + " | " + gameBoard[i][j] + " | ");
                }
                else
                {
                    System.out.print(gameBoard[i][j] + " | ");
                }
            }
            System.out.println("");
            currentRow++;
        }
        System.out.println("*****************");
    }

    public void assignPlayerOnePiece(int row, String column)
    {
        int actualColumn = 0;
        int actualRow = row-1;
        if (column.equals("a"))
        {
            actualColumn = 0;
        }
        else if (column.equals("b"))
        {
            actualColumn = 1;
        }
        else
        {
            actualColumn = 2;
        }
        gameBoard[actualRow][actualColumn] = 1;
    }

    public void assignPlayerTwoPiece(int row, String column)
    {
        int actualColumn = 0;
        int actualRow = row-1;
        if (column.equals("a"))
        {
            actualColumn = 0;
        }
        else if (column.equals("b"))
        {
            actualColumn = 1;
        }
        else
        {
            actualColumn = 2;
        }
        // It's important to note that we're using 5 for the second player's pieces because
        // we're calculating the winner based off of sums. So, if we used 2 instead of 5,
        // we could have false winners.
        gameBoard[actualRow][actualColumn] = 5;
    }

    public boolean checkForWinner()
    {
        boolean isItOver = false;

        // We need to check each row, so first row:
        int rowSum = 0;
        rowSum = gameBoard[0][0] + gameBoard[0][1] + gameBoard [0][2];
        if (rowSum == 3)
        {
            System.out.println("Player one wins!");
            isItOver = true;
        }
        else if (rowSum == 15)
        {
            System.out.println("Player two wins!");
            isItOver = true;
        }

        // Second row:
        rowSum = gameBoard[1][0] + gameBoard[1][1] + gameBoard [1][2];
        if (rowSum == 3)
        {
            System.out.println("Player one wins!");
            isItOver = true;
        }
        else if (rowSum == 15)
        {
            System.out.println("Player two wins!");
            isItOver = true;
        }

        // Third row:
        rowSum = gameBoard[1][0] + gameBoard[1][1] + gameBoard [1][2];
        if (rowSum == 3)
        {
            System.out.println("Player one wins!");
            isItOver = true;
        }
        else if (rowSum == 15)
        {
            System.out.println("Player two wins!");
            isItOver = true;
        }

        // We need to check the diagonal both ways, so we do top-left ot bottom-right first:
        int sumDiagonal = gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2];
        if (sumDiagonal == 3)
        {
            System.out.println("Player one wins!");
            isItOver = true;
        }
        else if (sumDiagonal == 15)
        {
            System.out.println("Player two wins!");
            isItOver = true;
        }

        // Now, we check the diagonal the opposite way
        sumDiagonal = gameBoard[2][0] + gameBoard[1][1] + gameBoard[0][2];
        if (sumDiagonal == 3)
        {
            System.out.println("Player one wins!");
            isItOver = true;
        }
        else if (sumDiagonal == 15)
        {
            System.out.println("Player two wins!");
            isItOver = true;
        }

        // Finally, we need to check the columns:
        int sumColumn = gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0];
        if (sumColumn == 3)
        {
            System.out.println("Player one wins!");
            isItOver = true;
        }
        else if (sumColumn == 15)
        {
            System.out.println("Player two wins!");
            isItOver = true;
        }

        // Column 2:
        sumColumn = gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1];
        if (sumColumn == 3)
        {
            System.out.println("Player one wins!");
            isItOver = true;
        }
        else if (sumColumn == 15)
        {
            System.out.println("Player two wins!");
            isItOver = true;
        }

        // Column 3:
        sumColumn = gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2];
        if (sumColumn == 3)
        {
            System.out.println("Player one wins!");
            isItOver = true;
        }
        else if (sumColumn == 15)
        {
            System.out.println("Player two wins!");
            isItOver = true;
        }
        return isItOver;
    }
}
