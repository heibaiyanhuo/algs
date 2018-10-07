package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class A437_Path_Sum_III {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return countFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int countFrom(TreeNode node, int sum) {

        if (node == null) {
            return 0;
        }

        int target = sum - node.val;
        return (sum == node.val ? 1 : 0) + countFrom(node.left, target) + countFrom(node.right, target);
    }

    private int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode node, int currSum, int target, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        currSum += node.val;
        int res = map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        res += helper(node.left, currSum, target, map) + helper(node.right, currSum, target, map);
        map.put(currSum, map.get(currSum) - 1);
        return res;
    }
}
