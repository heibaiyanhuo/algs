package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A244_Shortest_Word_Distance_II {

    Map<String, List<Integer>> map = new HashMap<>();

    public A244_Shortest_Word_Distance_II(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                map.put(words[i], lst);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> lst1 = map.get(word1);
        List<Integer> lst2 = map.get(word2);
        int d = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < lst1.size() && j < lst2.size()) {
            int idx1 = lst1.get(i);
            int idx2 = lst2.get(j);
            if (idx1 < idx2) {
                d = Math.min(idx2 - idx1, d);
                i++;
            } else {
                d = Math.min(idx1 - idx2, d);
                j++;
            }
        }
        return d;
    }
}
