package leetcode.problems;

public class A348_Design_Tic_Tac_Toe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int size;

    public A348_Design_Tic_Tac_Toe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
        size = n;
    }

    private int move(int row, int col, int player) {
        int val = (player == 1 ? 1 : -1);
        rows[row] += val;
        cols[col] += val;
        if (row == col) {
            diagonal += val;
        }

        if (row + col == size - 1) {
            antiDiagonal += val;
        }
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size
                || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }
}
