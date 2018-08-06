package leetcode.problems;

import leetcode.datastructures.TreeNode;

public class A106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    private TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int n = inorder.length;
        return buildTreeHelper(postorder, 0, n, inorder, 0, n);
    }

    private TreeNode buildTreeHelper(int[] postorder, int sp, int ep, int[] inorder, int si, int ei) {
        if (sp >= inorder.length || ep <= 0 || si >= ei) {
            return null;
        }
        int rootVal = postorder[ep - 1];
        int idx = -1;
        for (int i = si; i < ei; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(postorder, sp, sp + idx - si + 1, inorder, si, idx);
        root.right = buildTreeHelper(postorder, sp + idx - si + 1, ep - 1, inorder, idx + 1, ei);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};

        A106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal solution = new A106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        System.out.println(solution.buildTree(inorder, postorder));
    }
}
