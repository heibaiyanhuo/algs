package leetcode.problems;

public class A392_Is_Subsequence {

    private boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        int sp = 0, tp = 0;
        while (sp < s.length() && tp < t.length()) {
            if (t.charAt(tp) == s.charAt(sp)) {
                sp++;
            }
            tp++;
        }
        if (sp == s.length()) {
            return true;
        }
        return false;
    }
}
