package leetcode.problems;

import java.util.*;

public class A438_Find_All_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        int N = p.length();
        int[] pmap = new int[26];
        for (int i = 0; i < N; i++) {
            pmap[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i; j <= s.length() - N; j+=N) {
                int k = j;
                int[] visited = Arrays.copyOf(pmap, 26);
                for (; k < j + N; k++) {
                    if (visited[s.charAt(k) - 'a']-- == 0) {
                        break;
                    }
                }
                if (k == j + N) {
                    res.add(j);
                }
            }
        }
        return res;

    }

    private List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        int N = p.length();
        int[] pmap = new int[128];
        for (int i = 0; i < N; i++) {
            pmap[p.charAt(i)]++;
        }
        int sp = 0, ep = 0, count = N;
        while (ep < s.length()) {
            if (pmap[s.charAt(ep++)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (ep - sp == N) {
                    res.add(sp);
                }
                if (pmap[s.charAt(sp++)]++ == 0) {
                    count++;
                }
            }
        }
        return res;

    }



}
