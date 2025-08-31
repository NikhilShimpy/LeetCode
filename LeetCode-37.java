class Solution {
    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][] box = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    row[i][num] = col[j][num] = box[boxIndex][num] = true;
                }
            }
        }

        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (i == 9) return true; 

        if (j == 9) return solve(board, i + 1, 0); 

        if (board[i][j] != '.') {
            return solve(board, i, j + 1); 
        }

        int boxIndex = (i / 3) * 3 + (j / 3);
        for (int num = 0; num < 9; num++) {
            if (!row[i][num] && !col[j][num] && !box[boxIndex][num]) {
               
                board[i][j] = (char) (num + '1');
                row[i][num] = col[j][num] = box[boxIndex][num] = true;

                if (solve(board, i, j + 1)) {
                    return true; 
                }

                board[i][j] = '.';
                row[i][num] = col[j][num] = box[boxIndex][num] = false;
            }
        }
        return false; 
    }
}
