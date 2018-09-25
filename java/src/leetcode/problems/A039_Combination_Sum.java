package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class A039_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int remains, int start) {
        if (remains == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= remains) {
                tempList.add(candidates[i]);
                backtracking(res, tempList, candidates, remains - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
