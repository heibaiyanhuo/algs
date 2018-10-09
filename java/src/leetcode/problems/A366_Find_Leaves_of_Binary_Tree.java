package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.*;

public class A366_Find_Leaves_of_Binary_Tree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        height(root, res);
        return res;
    }

    private int height(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return -1;
        }
        int h = 1 + Math.max(height(node.left, res), height(node.right, res));
        if (res.size() <= h) {
            res.add(new ArrayList<>());
        }
        res.get(h).add(node.val);
        // node.left = node.right = null;
        return h;
    }
}
