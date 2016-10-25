/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel {

    private int currentPlayer = 0;
    private int[][] gameArea = new int[3][3];
    private int winner = -1;
    private boolean gameOver = false;

    public GameBoard()
      {
        newGame();
      }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is successful the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     */
    public boolean play(int col, int row)
      {
        if (!gameOver)
        {
            if (gameArea[col][row] == -1)
            {
                gameArea[col][row] = currentPlayer;
                if (currentPlayer == 0)
                {
                    currentPlayer = 1;
                }
                else
                {
                    currentPlayer = 0;
                }
                return true;
            }
            return false;
        }
        return false;
      }

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
      {
        return currentPlayer;
      }

    /**
     * Check if the Game is over.
     *
     * @return
     */
    public boolean isGameOver()
      {
        //Collums [Col] [Row]
        if (gameArea[0][0] == gameArea[1][0]
                && gameArea[0][0] == gameArea[2][0]
                && gameArea[0][0] != -1)
        {

            return true;
        }
        if (gameArea[0][1] == gameArea[1][1]
                && gameArea[0][1] == gameArea[2][1]
                && gameArea[0][1] != -1)
        {
            return true;
        }
        if (gameArea[0][2] == gameArea[1][2]
                && gameArea[0][2] == gameArea[2][2]
                && gameArea[0][2] != -1)
        {
            return true;
        }
        //Rows
        if (gameArea[0][0] == gameArea[0][1]
                && gameArea[0][0] == gameArea[0][2]
                && gameArea[0][0] != -1)
        {
            return true;
        }
        if (gameArea[1][0] == gameArea[1][1]
                && gameArea[1][0] == gameArea[1][2]
                && gameArea[1][0] != -1)
        {
            return true;
        }
        if (gameArea[2][0] == gameArea[2][1]
                && gameArea[2][0] == gameArea[2][2]
                && gameArea[2][0] != -1)
        {
            return true;
        }
        //Diagonal
        if (gameArea[0][0] == gameArea[1][1]
                && gameArea[0][0] == gameArea[2][2]
                && gameArea[0][0] != -1)
        {
            return true;
        }
        if (gameArea[2][0] == gameArea[1][1]
                && gameArea[2][0] == gameArea[0][2]
                && gameArea[0][2] != -1)
        {
            return true;
        }
        if (isBoardFull() == true) {
            return true;
        }
        else
        {
            return false;
        }
      }
        // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameArea[i][j] == -1) {
                    isFull = false;
                }
            }
        }
        return isFull;
    }
    
    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
   public int getWinner() {
        if (isBoardFull() == true) {
            currentPlayer = -1;
        }
        if (currentPlayer == 1) {
            return 0;
        }
        if (currentPlayer == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
      {
        currentPlayer = 0;
        winner = -1;
        gameOver = false;

        for (int i = 0; i < gameArea.length; i++)
        {
            for (int j = 0; j < gameArea[0].length; j++)
            {
                gameArea[i][j] = -1;
            }
        }
      }
}
