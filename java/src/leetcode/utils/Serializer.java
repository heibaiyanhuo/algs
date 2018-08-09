package leetcode.utils;

import leetcode.datastructures.TreeNode;

import java.util.*;

public class Serializer {

    /**
     * Use level order to serialize a tree.
     * @param root, the root node of a tree
     * @return an string like "[1, 2, null]"
     */
    public String serialize(TreeNode root) {
        List<String> nodesValues = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null) {
                nodesValues.add("null");
            } else {
                nodesValues.add(String.valueOf(currentNode.val));
                queue.offer(currentNode.left);
                queue.offer(currentNode.right);
            }
        }
        for (int i = nodesValues.size() - 1; i >= 0; i--) {
            if (nodesValues.get(i).equals("null")) {
                nodesValues.remove(i);
            } else {
                break;
            }
        }
        return "[" + String.join(",", nodesValues) + "]";
    }


    public TreeNode deserialize(String sequence) {
        sequence = sequence.substring(1, sequence.length() - 1).replaceAll("\\s+", "");
        if (sequence.isEmpty()) {
            return null;
        }
        String[] nodesValues = sequence.split(",");
        if (nodesValues.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodesValues[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (i < nodesValues.length) {
                if (nodesValues[i].equals("null")) {
                    curr.left = null;
                } else {
                    curr.left = new TreeNode(Integer.parseInt(nodesValues[i]));
                    queue.offer(curr.left);
                }
            } else {
                curr.left = null;
            }
            i++;
            if (i < nodesValues.length) {
                if (nodesValues[i].equals("null")) {
                    curr.right = null;
                } else {
                    curr.right = new TreeNode(Integer.parseInt(nodesValues[i]));
                    queue.offer(curr.right);
                }
            } else {
                curr.right = null;
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) {
        Serializer s = new Serializer();
        TreeNode root = s.deserialize("]");
        System.out.println(s.serialize(root));
    }
}
