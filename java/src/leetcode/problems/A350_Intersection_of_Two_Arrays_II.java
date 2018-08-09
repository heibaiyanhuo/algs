package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A350_Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> wordsFreq = new HashMap<>();
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        for (int n: nums1) {
            wordsFreq.put(n, wordsFreq.containsKey(n) ? wordsFreq.get(n) + 1 : 1);
        }
        for (int n: nums2) {
            if (wordsFreq.size() == 0) {
                break;
            }
            if (wordsFreq.containsKey(n)) {
                result.add(n);
                int freq = wordsFreq.get(n);
                if (freq == 1) {
                    wordsFreq.remove(n);
                } else {
                    wordsFreq.put(n, freq - 1);
                }
            }
        }
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }

        return ret;
    }
}
