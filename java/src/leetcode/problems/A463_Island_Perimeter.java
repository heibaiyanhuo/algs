package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class A463_Island_Perimeter {

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return helper(grid, set, i, j, m, n);
                }
            }
        }
        return 0;
    }

    public int helper(int[][] grid, Set<Integer> set, int x, int y, int m, int n) {
        if (x < 0 || x == m || y < 0 || y == n || set.contains(x * n + y) || grid[x][y] == 0) {
            return 0;
        }
        int count = 0;
        if (x < m - 1 && set.contains((x + 1) * n + y)) count++;
        if (x > 0 && set.contains((x - 1) * n + y)) count++;
        if (y < n - 1 && set.contains(x * n + y + 1)) count++;
        if (y > 0 && set.contains(x * n + y - 1)) count++;
        set.add(x * n + y);
        return 4 - 2 * count + helper(grid, set, x + 1, y, m, n) + helper(grid, set, x - 1, y, m, n) + helper(grid, set, x, y + 1, m, n) + helper(grid, set, x, y - 1, m, n);
    }

    private int ip2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    result = result + 4;
                    if (i > 0 && grid[i - 1][j] == 1)
                        result = result - 2;
                    if (j > 0 && grid[i][j - 1] == 1)
                        result = result - 2;
                }
            }
        }
        return result;
    }
}
