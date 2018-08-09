package leetcode.problems;

import leetcode.datastructures.TreeNode;

public class A235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        int min = Math.min(p.val, q.val);
        int max = p.val + q.val - min;
        while (curr != null) {
            if (curr.val < min) {
                curr = curr.right;
            } else if (curr.val > max) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }
}
