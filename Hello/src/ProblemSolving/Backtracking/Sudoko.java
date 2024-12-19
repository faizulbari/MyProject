package ProblemSolving.Backtracking;

public class Sudoko {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    boolean solve(char[][] board, int position) {
        if (position == 81) {
            return true;
        }

        int row = position / 9;
        int col = position % 9;

        if (board[row][col] != '.') {
            return solve(board, position + 1);
        }
        for (char i = '1'; i <= '9'; i++) {
            if (isPlacementValid(row, col, board, i)) {
                board[row][col] = (char) i;
                if (solve(board, position + 1))
                    return true;
                board[row][col] = '.';

            }
        }
        return false;
    }

    boolean isPlacementValid(int row, int col, char[][] board, char digit) {
        //check rows and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit)
                return false;
        }
        int rowStart = (int) Math.floor(row / 3) * 3;
        int colStart = (int) Math.floor(col / 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == digit)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] arg) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {
                '.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {
                '4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {
                '.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {
                '.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Sudoko sudo = new Sudoko();
        sudo.solve(board, 0);

        System.out.println("Solution exists" + board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}

