package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class A036_Valid_Sudoku {


    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (!isValid(board, i, 0, i, 8)) {
                return false;
            }
            if (!isValid(board, 0, i, 8, i)) {
                return false;
            }
            int offset_x = (i / 3) * 3;
            int offset_y = (i % 3) * 3;
            if (!isValid(board, offset_x, offset_y, offset_x + 2, offset_y + 2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x1, int y1, int x2, int y2) {
        Set<Character> set = new HashSet<>();

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (board[x][y] != '.') {
                    if (board[x][y] > '9' || board[x][y] < '1' || !set.add(board[x][y])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println('.' < 'A');
    }
}
