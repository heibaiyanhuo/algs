package leetcode.problems;

import leetcode.datastructures.TreeNode;
import leetcode.utils.Serializer;

import java.util.ArrayList;
import java.util.List;

public class A257_Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(paths, path, root);
        return paths;
    }

    private void dfs(List<String> paths, StringBuilder path, TreeNode node) {
        if (node == null) {
            return;
        }
        int length = path.length();
        path.append(node.val);
        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        } else {
            path.append("->");
            dfs(paths, path, node.left);
            dfs(paths, path, node.right);
        }
        path.setLength(length);
    }

    public static void main(String[] args) {
        Serializer s = new Serializer();
        A257_Binary_Tree_Paths solution = new A257_Binary_Tree_Paths();
        TreeNode rt= s.deserialize("[1,2,3,null,5]");
        System.out.println(solution.binaryTreePaths(rt));
    }
}
