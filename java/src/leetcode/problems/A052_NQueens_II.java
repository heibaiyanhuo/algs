package leetcode.problems;

public class A052_NQueens_II {

    private int total = 0;
    public int totalNQueens(int n) {
        int[] pos = new int[n];
        dfs(pos, 0, n);
        return total;
    }

    boolean isValid(int[] position, int k) {
        for (int i = 0; i < k; i++) {
            if (Math.abs(position[i] - position[k]) == Math.abs(i - k) || position[i] == position[k]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int[] pos, int k, int n) {
        if (k == n) {
            total++;
            return;
        }
        for (int i = 0; i < n; i++) {
            pos[k] = i;
            if (isValid(pos, k)) {
                dfs(pos, k + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        A052_NQueens_II solution = new A052_NQueens_II();
        System.out.println(solution.totalNQueens(8));
    }
}
