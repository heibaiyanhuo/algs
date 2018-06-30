package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.*;

public class A102_Binary_Tree_Level_Order_Traversal {

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            Integer[] levelNodes = new Integer[length];
            for (int i = 0; i < length; i++) {
                TreeNode curr = queue.poll();
                levelNodes[i] = curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ret.add(Arrays.asList(levelNodes));
        }

        return ret;
    }


    private List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        preorderHelper(ret, 0, root);
        return ret;
    }

    private void preorderHelper(List<List<Integer>> res, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        preorderHelper(res, level + 1, node.left);
        preorderHelper(res, level + 1, node.right);
    }
}
