package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class A247_Strobogrammatic_Number_II {

    private List<String> findStrobogrammatic(int n) {
        char[] num = new char[n];
        List<String> res = new ArrayList<>();
        backtracking(res, num, 0, n - 1);
        return res;
    }

    private void backtracking(List<String> res, char[] num, int s, int e) {
        if (s > e) {
            res.add(String.valueOf(num));
            return;
        } else if (s == e) {
            num[s] = '1';
            res.add(String.valueOf(num));
            num[s] = '8';
            res.add(String.valueOf(num));
            if (num.length == 1 || s != 0) {
                num[s] = '0';
                res.add(String.valueOf(num));
            }
            return;
        }
        num[s] = '1';
        num[e] = '1';
        backtracking(res, num, s + 1, e - 1);
        num[s] = '8';
        num[e] = '8';
        backtracking(res, num, s + 1, e - 1);
        num[s] = '6';
        num[e] = '9';
        backtracking(res, num, s + 1, e - 1);
        num[s] = '9';
        num[e] = '6';
        backtracking(res, num, s + 1, e - 1);
        if (s != 0) {
            num[s] = '0';
            num[e] = '0';
            backtracking(res, num, s + 1, e - 1);
        }
    }

    public static void main(String[] args) {
        A247_Strobogrammatic_Number_II solution = new A247_Strobogrammatic_Number_II();
        System.out.println(solution.findStrobogrammatic(3));
    }
}
