package leetcode.problems;

import leetcode.datastructures.ListNode;

public class A086_Partition_List {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode p = head;
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        p1.next = dummy2.next;
        p2.next = null;

        return dummy1.next;
    }

    public ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        dummy1.next = head;
        ListNode p = dummy1;
        ListNode q = dummy2;
        while (p != null) {
            ListNode p1 = p;
            while (p1.next != null && p1.next.val >= x) {
                q.next = p1.next;
                q = q.next;
                p1 = p1.next;
            }
            p.next = p1.next;
            if (p.next == null) {
                q.next = null;
                p.next = dummy2.next;
                break;
            } else {
                p = p.next;
            }
        }

        return dummy1.next;
    }

}
