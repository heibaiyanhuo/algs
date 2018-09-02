package leetcode.problems;

import java.util.*;

public class A819_Most_Common_Word {

    private String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[ !\\?;',\\.]");
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            word = word.toLowerCase();
            if (word.length() > 0 && !bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int maxFreq = 0;
        String target = "";
        for (String key: map.keySet()) {
            int freq = map.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
                target = key;
            }
        }
        return target;
    }

}
