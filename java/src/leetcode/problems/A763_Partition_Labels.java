package leetcode.problems;

import java.util.*;

public class A763_Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return result;
        }
        Map<Character, int[]> intervalsMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (intervalsMap.containsKey(c)) {
                intervalsMap.get(c)[1] = i;
            } else {
                intervalsMap.put(c, new int[]{i, i});
            }
        }
        int N = intervalsMap.size();
        List<int[]> intervals = new ArrayList<>(intervalsMap.values());

        intervals.sort(Comparator.comparing((interval -> interval[0])));
        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];
        for (int i = 0; i < N; i++) {
            int[] curr = intervals.get(i);
            if (curr[0] <= end) {
                end = Math.max(end, curr[1]);
            } else {
                result.add(end - start + 1);
                start = curr[0];
                end = curr[1];
            }
        }
        result.add(end - start + 1);
        return result;
    }

    public List<Integer> partitionLabels2(String S) {
        List<Integer> result = new ArrayList<>();
        int sp = 0;
        while (sp < S.length()) {
            char c = S.charAt(sp);
            int ep = S.lastIndexOf(c);
            if (ep == -1) {
                result.add(1);
                sp++;
                continue;
            }

            for (int i = sp + 1; i <= ep; i++) {
                ep = Math.max(ep, S.lastIndexOf(S.charAt(i)));
            }
            result.add(ep - sp + 1);
            sp = ep + 1;
        }
        return result;
    }


}
