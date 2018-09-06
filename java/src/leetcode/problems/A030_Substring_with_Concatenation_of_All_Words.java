package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A030_Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int wordLength = words[0].length();
        int N = words.length;
        int sLength = s.length();
        int subLength = wordLength * N;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> visited = new HashMap<>();
        for (int i = 0; i < sLength - subLength + 1; i++) {
            int j = 0;
            while (j < N) {
                String sub = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (wordMap.containsKey(sub)) {
                    visited.put(sub, visited.getOrDefault(sub, 0) + 1);
                    if (visited.get(sub) > wordMap.get(sub)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            visited.clear();
            if (j == N) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        int wordLength = words[0].length();
        int N = words.length;
        int sLength = s.length();
        int windowLength = wordLength * N;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> visited = new HashMap<>();
        for (int i = 0; i < wordLength; i++) {
            for (int j = i; j + windowLength <= sLength; j+=wordLength) {
                String window = s.substring(j, j + windowLength);
                for (int k = 0; k < N; k++) {
                    String word = window.substring(j + k * wordLength, j + (k + 1) * wordLength);
                    int count = visited.getOrDefault(word, 0) + 1;
                    if (count > wordMap.getOrDefault(word, 0)) {
                        j += k * wordLength;
                        break;
                    } else if (k == N - 1) {
                        res.add(j);
                    } else {
                        visited.put(word, count);
                    }
                }
                visited.clear();
            }
        }
        return res;
    }
}
