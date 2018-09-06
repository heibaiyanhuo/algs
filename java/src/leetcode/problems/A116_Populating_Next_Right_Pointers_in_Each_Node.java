package leetcode.problems;

import leetcode.datastructures.TreeLinkNode;


public class A116_Populating_Next_Right_Pointers_in_Each_Node {

    private void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        root.next = null;
        TreeLinkNode nextLevelHead;
        while (root != null && root.left != null) {
            nextLevelHead = root.left;
            while (root != null) {
                root.left.next = root.right;
                if (root.next == null) {
                    root.right.next = null;
                    break;
                } else {
                    root.right.next = root.next.left;
                }
                root = root.next;
            }
            root = nextLevelHead;
        }
    }
}
