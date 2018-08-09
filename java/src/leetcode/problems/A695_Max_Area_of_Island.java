package leetcode.problems;

public class A695_Max_Area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int maxArea = 0;
        int[] aux = new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    aux[0] = 0;
                    dfs(grid, i, j, aux);
                    maxArea = Math.max(aux[0], maxArea);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int x, int y, int[] area) {
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0 || grid[x][y] == -1) {
            return;
        }
        area[0] += 1;
        grid[x][y] = -1;
        dfs(grid, x + 1, y, area);
        dfs(grid, x, y + 1, area);
        dfs(grid, x - 1, y, area);
        dfs(grid, x, y - 1, area);
    }
}
