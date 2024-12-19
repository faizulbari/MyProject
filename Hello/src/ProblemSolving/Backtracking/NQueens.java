package ProblemSolving.Backtracking;

import java.util.Arrays;

public class NQueens {
    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(board, 0);
    }

    private static void backtrack(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for(int i =0 ; i<board.length ; i++)
            if ( board[row][i] == 'Q' || board[i][col] == 'Q' ) return false;

        for(int i = row-1 , j = col-1 ; i>=0 && j>=0 ; i--,j--)
            if(board[i][j]=='Q') return false;

        for(int i=row-1,j=col+1; i>=0 && j<board.length ; i--,j++)
            if(board[i][j]=='Q') return false;

        return true;
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(String.valueOf(row));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solveNQueens(4); // Example: 4-queens
    }
}
