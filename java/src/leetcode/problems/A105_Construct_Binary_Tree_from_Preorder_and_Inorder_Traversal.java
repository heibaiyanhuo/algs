package leetcode.problems;

import leetcode.datastructures.TreeNode;

public class A105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int sp, int[] inorder, int si, int ei) {
        if (sp >= preorder.length || si > ei) {
            return null;
        }
        int rootVal = preorder[sp];
        int idx = -1;
        for (int i = si; i <= ei; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, sp + 1, inorder, si, idx - 1);
        root.right = buildTreeHelper(preorder, sp + idx - si + 1, inorder, idx + 1, ei);
        return root;
    }


}
