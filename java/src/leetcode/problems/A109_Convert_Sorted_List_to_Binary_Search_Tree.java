package leetcode.problems;

import leetcode.datastructures.ListNode;
import leetcode.datastructures.TreeNode;

public class A109_Convert_Sorted_List_to_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    private TreeNode build(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = build(start, slow);
        root.right = build(slow.next, end);
        return root;
    }
}
