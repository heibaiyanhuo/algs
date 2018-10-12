package leetcode.problems;

import leetcode.datastructures.TreeNode;

public class A124_Binary_Tree_Maximum_Path_Sum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        max = Math.max(max, left + node.val + right);
        return node.val + Math.max(left, right);
    }
}
