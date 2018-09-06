package leetcode.problems;

import leetcode.datastructures.TreeNode;

public class A129_Sum_Root_to_Leaf_Numbers {

    private int sum = 0;

    private int sumNumbers(TreeNode root) {
        dfsHelper(0, root);
        return sum;
    }

    private void dfsHelper(int pathSum, TreeNode node) {
        if (node == null) {
            return;
        }

        pathSum = pathSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            sum += pathSum;
            return;
        }
        dfsHelper(pathSum, node.left);
        dfsHelper(pathSum, node.right);
    }
}
