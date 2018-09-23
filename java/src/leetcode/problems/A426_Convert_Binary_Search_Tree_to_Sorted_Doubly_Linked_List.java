package leetcode.problems;

public class A426_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {
    static private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node first = null;
    private Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inorder(root);
        first.left = last;
        last.right = first;
        return first;
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            if (last == null) {
                first = node;
                last = node;
            } else {
                last.right = node;
                node.left = last;
                last = node;
            }
            inorder(node.right);
        }
    }
}
