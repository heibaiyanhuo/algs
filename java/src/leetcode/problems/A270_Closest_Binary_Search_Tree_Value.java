package leetcode.problems;

import leetcode.datastructures.TreeNode;

public class A270_Closest_Binary_Search_Tree_Value {
    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        int res = curr.val;
        while (curr != null) {
            if (Math.abs(res - target) > Math.abs(curr.val - target)) {
                res = curr.val;
            }
            if (curr.val > target) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return res;
    }
}
