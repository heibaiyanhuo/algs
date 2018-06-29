package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class A103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        preorderHelper(ret, 0, root, true);
        return ret;
    }

    private void preorderHelper(List<List<Integer>> res, int level, TreeNode node, boolean left) {
        if (node == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        if (left) {
            res.get(level).add(node.val);
        } else {
            res.get(level).add(0, node.val);
        }
        preorderHelper(res, level + 1, node.left, !left);
        preorderHelper(res, level + 1, node.right, !left);
    }
}
