package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class A222_Count_Complete_Tree_Nodes {

    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 : (height(root.right) == h - 1 ? (1 << h) + countNodes(root.right) : (1 << (h - 1)) + countNodes(root.left));
    }

    private int height(TreeNode node) {
        return node == null ? -1 : 1 + height(node.left);
    }
}
