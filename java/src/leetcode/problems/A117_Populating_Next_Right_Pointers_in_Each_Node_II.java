package leetcode.problems;


import leetcode.datastructures.TreeLinkNode;

public class A117_Populating_Next_Right_Pointers_in_Each_Node_II {
    private void connect(TreeLinkNode root) {
        TreeLinkNode nextLevelHead = null;
        TreeLinkNode nextLevelTail = null;
        TreeLinkNode curr = root;

        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (nextLevelTail != null) {
                        nextLevelTail.next = curr.left;
                    } else {
                        nextLevelHead = curr.left;
                    }
                    nextLevelTail = curr.left;
                }
                if (curr.right != null) {
                    if (nextLevelTail != null) {
                        nextLevelTail.next = curr.right;
                    } else {
                        nextLevelHead = curr.right;
                    }
                    nextLevelTail = curr.right;
                }
                curr = curr.next;
            }
            curr = nextLevelHead;
            nextLevelHead = null;
            nextLevelTail = null;
        }

    }

}
