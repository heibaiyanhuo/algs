package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class A678_Valid_Parenthesis_String {

    public boolean checkValidString(String s) {
        Deque<Integer> par = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                par.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (!par.isEmpty()) {
                    par.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        while (!par.isEmpty() && !star.isEmpty()) {
            if (par.pop() > star.pop()) {
                return false;
            }
        }
        return par.isEmpty();
    }

    private boolean checkValidString2(String s) {
        int lo = 0, hi = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == '*') {
                if (lo > 0) {
                    lo--;
                }
                hi++;
            } else {
                if (lo > 0) {
                    lo--;
                }
                hi--;
            }

            if (hi < 0) {
                return false;
            }
        }

        return lo == 0;
    }
}
