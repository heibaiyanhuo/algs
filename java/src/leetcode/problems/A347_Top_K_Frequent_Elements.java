package leetcode.problems;

import java.util.*;

public class A347_Top_K_Frequent_Elements {
    static class IntegerFrequence {
        int val;
        int frequence;
        IntegerFrequence(int val, int frequence) {
            this.val = val;
            this.frequence = frequence;
        }

    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Queue<IntegerFrequence> queue = new PriorityQueue<>(Comparator.comparing(o -> o.frequence));
        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            queue.offer(new IntegerFrequence(entry.getKey(), entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(0, queue.poll().val);
        }
        return result;
    }

    private List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            if (!map.containsKey(entry.getValue())) {
                map.put(entry.getValue(), new ArrayList<>());
            } else {
                map.get(entry.getValue()).add(entry.getKey());
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length;  i >= 0 && res.size() < k; i--) {
            if (map.containsKey(i)) {
                res.addAll(map.get(i));
            }
        }
        return res;
    }
}
