package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class A022_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 0) {
            return ret;
        }
        char[] res = new char[2 * n];
        dfs(res, 0, n, n, ret);
        return ret;
    }

    private void dfs(char[] res, int index, int open, int closed, List<String> ret) {
        if (index == res.length) {
            ret.add(new String(res));
            return;
        }
        if (open > 0) {
            res[index] = '(';
            dfs(res, index + 1, open - 1, closed, ret);
        }
        if (closed > open) {
            res[index] = ')';
            dfs(res, index + 1, open, closed - 1, ret);
        }
    }

    public static void main(String[] args) {
        A022_Generate_Parentheses solution = new A022_Generate_Parentheses();
        System.out.println(solution.generateParenthesis(3));
    }
}
