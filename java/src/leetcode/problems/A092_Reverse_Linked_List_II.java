package leetcode.problems;

import leetcode.datastructures.ListNode;

public class A092_Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy; // node before reversing
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode p = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = p.next;
            p.next = pre.next;
            pre.next = p;
            p = start.next;
        }
        return dummy.next;
    }
}
