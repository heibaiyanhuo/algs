package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A090_Subsets_II {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        Arrays.sort(nums);
        dfs(new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<Integer> subset, int[] nums, int idx) {
        if (idx <= nums.length) {
            res.add(new ArrayList<>(subset));
        }

        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(subset, nums, i + 1);
            subset.remove(subset.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return;
    }

    public static void main(String[] args) {
        A090_Subsets_II solution = new A090_Subsets_II();
        List<List<Integer>> list = solution.subsetsWithDup(new int[]{1, 2});
        System.out.println(list.toString());

    }
}
