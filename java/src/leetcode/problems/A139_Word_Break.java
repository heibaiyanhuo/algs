package leetcode.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class  A139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String word: wordDict) {
            words.add(word);
        }
        int l = s.length();
        boolean[] dp = new boolean[l + 1];
        dp[0] = true;
        for (int i = 1; i <= l; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[l];
    }
}
