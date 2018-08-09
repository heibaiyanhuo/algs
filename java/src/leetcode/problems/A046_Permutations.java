package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A046_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permutations;
        }
        List<Integer> permutation = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        dfs(permutations, permutation, used, nums);
        return permutations;
    }

    private void dfs(List<List<Integer>> permutations, List<Integer> permutation, Set<Integer> used, int[] nums) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i)) {
                used.add(i);
                permutation.add(nums[i]);
                dfs(permutations, permutation, used, nums);
                permutation.remove(permutation.size() - 1);
                used.remove(i);
            }
        }
    }
}
