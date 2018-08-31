package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.*;

public class A314_Binary_Tree_Vertical_Order_Traversal {

    private List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> positionQueue = new LinkedList<>();
        int min = 0;
        int max = 0;
        nodeQueue.offer(root);
        positionQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.poll();
            int currPos = positionQueue.poll();
            min = Math.min(min, currPos);
            max = Math.max(max, currPos);
            if (!map.containsKey(currPos)) {
                map.put(currPos, new ArrayList<>());
            }
            map.get(currPos).add(curr.val);
            if (curr.left != null) {
                nodeQueue.offer(curr.left);
                positionQueue.offer(currPos - 1);
            }
            if (curr.right != null) {
                nodeQueue.offer(curr.right);
                positionQueue.offer(currPos + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }

}
