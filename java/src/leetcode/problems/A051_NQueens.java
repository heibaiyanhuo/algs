package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A051_NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[] builder = new char[n];
        Arrays.fill(builder, '.');
        int[] pos = new int[n];
        dfs(res, builder, pos, 0, n);
        return res;
    }

    private boolean isValid(int[] position, int k) {
        for (int i = 0; i < k; i++) {
            if (Math.abs(position[i] - position[k]) == Math.abs(i - k) || position[i] == position[k]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<String>> res, char[] builder, int[] pos, int k, int n) {
        if (k == n) {
            List<String> tmp = new ArrayList<>();
            for (int p: pos) {
                builder[p] = 'Q';
                tmp.add(String.valueOf(builder));
                builder[p] = '.';
            }
            res.add(tmp);
            return;
        }
        for (int i = 0; i < n; i++) {
            pos[k] = i;
            if (isValid(pos, k)) {
                dfs(res, builder, pos, k + 1, n);
            }
        }
    }
}
