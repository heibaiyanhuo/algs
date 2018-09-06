package leetcode.problems;

public class A003_Longest_Substring_Without_Repeating_Characters {
    private int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] freq = new int[128];
        int count = 0;
        int bp = 0, ep = 0, l = 1;
        while (ep < s.length()) {
            if (freq[s.charAt(ep++)]++ > 0) count++;
            while (count > 0) {
                if (freq[s.charAt(bp++)]-- > 1) count--;
            }
            l = Math.max(ep - bp, l);
        }
        return l;
    }
}
