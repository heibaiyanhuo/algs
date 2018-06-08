package leetcode.problems;

import leetcode.datastructures.TreeNode;
import leetcode.utils.Serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A297_Serialize_and_Deserialize_Binary_Tree {

    /**
     * Use preorder to serialize and deserialize
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<String> nodesValues = new ArrayList<>();
        serializeHelper(root, nodesValues);
        return String.join(",", nodesValues);
    }

    private void serializeHelper(TreeNode node, List<String> nodesValues) {
        if (node == null) {
            nodesValues.add("#");
            return;
        }
        nodesValues.add(String.valueOf(node.val));
        serializeHelper(node.left, nodesValues);
        serializeHelper(node.right, nodesValues);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodesValues = data.split(",");
        int[] index = new int[]{-1};
        return createTreeNode(index, nodesValues);
    }

    private TreeNode createTreeNode(int[] index, String[] nodesValues) {
        index[0]++;
        if (nodesValues[index[0]].equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodesValues[index[0]]));
        node.left = createTreeNode(index, nodesValues);
        node.right = createTreeNode(index, nodesValues);
        return node;
    }

    public static void main(String[] args) {
        Serializer s = new Serializer();
        TreeNode rt = s.deserialize("[1, 2, 3, null, null, 4, 5]");
        A297_Serialize_and_Deserialize_Binary_Tree solution = new A297_Serialize_and_Deserialize_Binary_Tree();

        System.out.println(solution.serialize(solution.deserialize("1,2,#,#,3,4,#,#,5,#,#")));
    }
}
