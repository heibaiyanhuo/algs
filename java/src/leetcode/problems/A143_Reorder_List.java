package leetcode.problems;

import leetcode.datastructures.ListNode;

public class A143_Reorder_List {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = null;
        ListNode p = slow.next;
        slow.next = null;
        while (p != null) {
             ListNode tmp = p.next;
             p.next = rev;
             rev = p;
             p = tmp;
        }
        p = head;
        ListNode q = rev;
        while (p != null && q != null) {
            ListNode tmp1 = p.next;
            p.next = q;
            ListNode tmp2 = q.next;
            q.next = tmp1;
            q = tmp2;
            p = tmp1;
        }

    }
}
