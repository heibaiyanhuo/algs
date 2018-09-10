package leetcode.problems;

import java.util.*;

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
                for (int k = N - 1; k >= 0; k--) {
                    String word = window.substring(k * wordLength, (k + 1) * wordLength);
                    int count = visited.getOrDefault(word, 0) + 1;
                    if (count > wordMap.getOrDefault(word, 0)) {
                        j += k * wordLength;
                        break;
                    } else if (k == 0) {
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

    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        int N = words[0].length();
        int subLength = N * words.length;
        int sp = 0, ep = 0;
        Map<String, Integer> visited = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int count = wordMap.size();
            sp = i;
            ep = i;
            while (ep <= s.length() - subLength) {
                String word = s.substring(ep, ep + N);
                if (visited.getOrDefault(word, 0) < wordMap.getOrDefault(word, 0)) {
                    visited.put(word, visited.getOrDefault(word, 0) + 1);
                    if (visited.get(word).equals(wordMap.get(word))) count--;
                }
                ep += N;
                while (count == 0) {
                    if (ep - sp == subLength) {
                        res.add(sp);
                    }
                    String tmp = s.substring(sp, sp + N);
                    if (visited.containsKey(tmp)) {
                        if (visited.get(tmp).equals(wordMap.get(tmp))) count++;
                        visited.put(tmp, visited.get(tmp) - 1);
                    }
                    sp += N;
                }
            }
            visited.clear();
        }
        return res;
    }
}
