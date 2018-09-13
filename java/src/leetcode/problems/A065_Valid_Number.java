package leetcode.problems;

import java.util.regex.Pattern;

public class A065_Valid_Number {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfter = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                numberSeen = true;
            } else if (c == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfter = false;
            } else if (c == '+' || c == '-') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfter;
    }
}
