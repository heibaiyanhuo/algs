package leetcode.utils;

import leetcode.datastructures.TreeNode;

public class Serializer {

    /**
     * Use level order to serialize a tree.
     * @param root, the root node of a tree
     * @return an string like "[1, 2, null]"
     */
    public static String serialize(TreeNode root) {
        StringBuilder sequenceBuilder = new StringBuilder("[");
        return null;
    }


    public static TreeNode deserialize(String sequence) {
        String[] nodesVals = sequence.replaceAll("\\s+", "").split(",");
        return createTreeNode(0, nodesVals);
    }


    private static TreeNode createTreeNode(int index, String[] nodesVals) {
        if (index >= nodesVals.length || nodesVals[index] == "null") {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodesVals[index]));
        node.left = createTreeNode(2 * index + 1, nodesVals);
        node.right = createTreeNode(2 * index + 2, nodesVals);
        return node;
    }
}
