package leetcode.problems;

import leetcode.datastructures.TreeNode;
import leetcode.utils.Serializer;

import java.util.*;

public class A094_Binary_Tree_Inorder_Traversal {

    /**
     * Do it iteratively.
     * @param root
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
        Serializer s = new Serializer();
        A094_Binary_Tree_Inorder_Traversal solution = new A094_Binary_Tree_Inorder_Traversal();
        List result = solution.inorderTraversal(s.deserialize("[1, null, 2, 3]"));
        System.out.println(result.toString());
    }
}
