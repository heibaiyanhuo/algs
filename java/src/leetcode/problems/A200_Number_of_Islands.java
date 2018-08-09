package leetcode.problems;

public class A200_Number_of_Islands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    helper(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i == rows || j < 0 || j == cols || grid[i][j] == '#' || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '#';
        helper(grid, i + 1, j, rows, cols);
        helper(grid, i, j + 1, rows, cols);
        helper(grid, i - 1, j, rows, cols);
        helper(grid, i, j - 1, rows, cols);
    }


}
