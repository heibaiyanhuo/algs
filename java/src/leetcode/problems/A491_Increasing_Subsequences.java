package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A491_Increasing_Subsequences {
    private List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> sequence, int[] nums, int start) {
        if (sequence.size() > 1) {
            res.add(new ArrayList<>(sequence));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (sequence.isEmpty() || nums[i] >= sequence.get(sequence.size() - 1)) {
                set.add(nums[i]);
                sequence.add(nums[i]);
                dfs(res, sequence, nums, i + 1);
                sequence.remove(sequence.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        A491_Increasing_Subsequences solution = new A491_Increasing_Subsequences();
        System.out.println(solution.findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
