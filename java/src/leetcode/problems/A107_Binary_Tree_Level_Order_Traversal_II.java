package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.*;

public class A107_Binary_Tree_Level_Order_Traversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            Integer[] levelArr = new Integer[levelLength];
            for (int i = 0; i < levelLength; i++) {
                TreeNode currNode = queue.poll();
                levelArr[i] = currNode.val;
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            res.add(0, Arrays.asList(levelArr));
        }

        return res;
    }
}
