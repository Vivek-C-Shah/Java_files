/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (!check(board, board[i][j], i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean check(char[][] board, char num, int r, int c) {
        for (int i = 0; i < board.length; i++) {
            if (i != r && board[i][c] == num) {
                return false;
            }
        }
        for (int j = 0; j < board[r].length; j++) {
            if (j != c && board[r][j] == num) {
                return false;
            }
        }
        int boxRow = 3 * (r / 3);
        int boxCol = 3 * (c / 3);
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (i != r && j != c && board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
