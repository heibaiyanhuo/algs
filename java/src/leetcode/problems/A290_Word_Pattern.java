package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;

public class A290_Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (strArr.length != pattern.length()) {
            return false;
        }
        String[] map = new String[26];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            int idx = pattern.charAt(i) - 'a';
            String word = strArr[i];
            if (map[idx] == null) {
                if (set.contains(word)) {
                    return false;
                }
                map[idx] = strArr[i];
                set.add(word);
            } else if (!map[idx].equals(word)){
                return false;
            }
        }
        return true;
    }
}
