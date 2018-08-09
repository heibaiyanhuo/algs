package leetcode.problems;

import leetcode.datastructures.TreeNode;



public class A098_Validate_Binary_Search_Tree {

    Integer LAST = null;

    private boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (!isValidBST(root.left)) {
                return false;
            }
            if (LAST != null && root.val <= LAST) {
                return false;
            }
            LAST = root.val;
            if (!isValidBST(root.right)) {
                return false;
            }
        }
        return true;
    }

}
