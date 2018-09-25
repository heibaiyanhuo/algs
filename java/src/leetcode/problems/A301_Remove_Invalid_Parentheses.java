package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A301_Remove_Invalid_Parentheses {

    private final char[] par = new char[]{'(', ')'};
    private final char[] parRev = new char[]{')', '('};

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        helper(s, res, 0, 0, par);
        return res;
    }

    private void helper(String source, List<String> res, int start, int last, char[] par) {
        int count = 0;
        for (int i = start; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c == par[0]) count++;
            if (c == par[1]) count--;
            if (count >= 0) continue;
            for (int j = last; j <= i; j++) {
                if (source.charAt(j) == par[1] && (j == last || source.charAt(j - 1) != par[1])) {
                    helper(source.substring(0, j) + source.substring(j + 1), res, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(source).reverse().toString();
        if (par[0] == '(') helper(reversed, res, 0, 0, this.parRev);
        else res.add(reversed);
    }


    private List<String> removeInvalidParentheses2(String s) {

        return null;
    }

    private String removeInvalidPar(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                int size = res.length();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.insert(size, stack.pop());
                }
                if (!stack.isEmpty()) {
                    res.insert(size, stack.pop()).append(')');
                }
            } else {
                stack.push(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        A301_Remove_Invalid_Parentheses solution = new A301_Remove_Invalid_Parentheses();
        String a = "(()(abc)(aa)";
        System.out.println(solution.removeInvalidPar(a));
    }
}
