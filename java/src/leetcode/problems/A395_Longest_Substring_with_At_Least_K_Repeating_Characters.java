package leetcode.problems;

import java.util.Arrays;

public class A395_Longest_Substring_with_At_Least_K_Repeating_Characters {

    private int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), k, 0, s.length());
    }

    private int helper(char[] str, int k, int start, int end) {
        if (end - start < k) {
            return 0;
        }
        int[] map = new int[26];
        for (int i = start; i < end; i++) {
            map[str[i] - 'a']++;
        }
        int max = 0, tmp = start;
        for (int i = start; i < end; i++) {
            if (map[str[i] - 'a'] < k) {
                max = Math.max(max, helper(str, k, start, i));
                start = i + 1;
            }
        }
        if (start == tmp) return end - start;
        return Math.max(max, helper(str, k, start, end));
    }

    private int longerstSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;

        for (h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            i = 0;
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }

        return max;
    }
}
