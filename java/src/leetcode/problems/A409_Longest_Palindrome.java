package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class A409_Longest_Palindrome {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                res += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) {
            res += 1;
        }
        
        return res;
    }
}
