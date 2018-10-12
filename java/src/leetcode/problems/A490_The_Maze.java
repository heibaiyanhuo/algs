package leetcode.problems;

public class A490_The_Maze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        return dfs(maze, start[0], start[1], m, n, destination);
    }

    private boolean dfs(int[][] maze, int x, int y, int m, int n, int[] destination) {
        if (x < 0 || x == m || y < 0 || y == n || maze[x][y] == -1) {
            return false;
        }
        if (x == destination[0] && y == destination[1]) {
            return true;
        }
        maze[x][y] = -1;
        boolean b1 = false, b2 = false, b3 = false, b4 = false;
        for (int i = 0; y + i <= n; i++) {
            if (y + i == n || maze[x][y + i] == 1) {
                b1 = dfs(maze, x, y + i - 1, m, n, destination);
                break;
            }
        }
        for (int i = 0; y - i >= -1; i--) {
            if (y - i == -1 || maze[x][y - i] == 1) {
                b2 = dfs(maze, x, y - i + 1, m, n, destination);
                break;
            }
        }
        for (int i = 0; x + i <=  m; i++) {
            if (x + i == m || maze[x + i][y] == 1) {
                b3 = dfs(maze, x + i - 1, y, m, n, destination);
                break;
            }
        }
        for (int i = 0; x - i >= -1; i--) {
            if (x - i == -1 || maze[x - i][y] == 1) {
                b4 = dfs(maze, x - i + 1, y, m, n, destination);
                break;
            }
        }
        return b1 || b2 || b3 || b4;
    }
}
