package leetcode.problems;

import java.util.Arrays;

public class A498_Diagonal_Traverse {

    private int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0|| matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int[][] directions = new int[][]{{-1, 1}, {1, -1}};
        int d = 0;
        int row = 0, col = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[row][col];
            row += directions[d][0];
            col += directions[d][1];
            if (row == m) {
                row = m - 1;
                col += 2;
                d ^= 1;
            } else if (col == n) {
                col = n - 1;
                row += 2;
                d ^= 1;
            } else if (row < 0) {
                row = 0;
                d ^= 1;
            } else if (col < 0) {
                col = 0;
                d ^= 1;
            }
        }
        return res;
    }

}
