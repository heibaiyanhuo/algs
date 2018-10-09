package leetcode.problems;

import leetcode.datastructures.TreeNode;

import java.util.*;

public class A449_Serialize_and_Deserialize_BST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> values = new ArrayList<>();
        preOrder(root, values);
        return String.join(",", values);
    }

    private void preOrder(TreeNode node, List<String> values) {
        if (node != null) {
            values.add(String.valueOf(node.val));
            preOrder(node.left, values);
            preOrder(node.right, values);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(Integer.MIN_VALUE, Integer.MAX_VALUE, queue);
    }

    private TreeNode build(int min, int max, Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        int val = Integer.parseInt(queue.peek());
        if (min < val && val < max) {
            queue.poll();
            TreeNode node = new TreeNode(val);
            node.left = build(min, node.val, queue);
            node.right = build(node.val, max, queue);
            return node;
        }
        return null;
    }

}
