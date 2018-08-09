package leetcode.problems;

import leetcode.datastructures.TreeNode;
import leetcode.utils.Serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A094_Binary_Tree_Inorder_Traversal {

    /**
     * Do it iteratively.
     * @param root
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if (curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        return null;
    }

    public static void main(String[] args) {
        Serializer s = new Serializer();
        A094_Binary_Tree_Inorder_Traversal solution = new A094_Binary_Tree_Inorder_Traversal();
        List result = solution.inorderTraversal(s.deserialize("[1, null, 2, 3]"));
        System.out.println(result.toString());
    }
}
