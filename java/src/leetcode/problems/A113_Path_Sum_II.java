package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class A113_Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsHelper(result, path, root, sum);
        return result;
    }

    private void dfsHelper(List<List<Integer>> result, List<Integer> path, TreeNode node, int remains) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node.val == remains) {
                path.add(node.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(node.val);
        if (node.left != null) {
            dfsHelper(result, path, node.left, remains - node.val);
        }
        if (node.right != null) {
            dfsHelper(result, path, node.right, remains - node.val);
        }
        path.remove(path.size() - 1);
    }
}
