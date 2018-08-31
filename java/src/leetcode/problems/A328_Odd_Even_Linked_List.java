package leetcode.problems;

import leetcode.datastructures.ListNode;

public class A328_Odd_Even_Linked_List {

    private ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode po = head;
        ListNode pe = evenHead;
        while (pe != null && pe.next != null) {
            po.next = pe.next;
            pe.next = po.next.next;
            po = po.next;
            pe = pe.next;
        }
        po.next = evenHead;
        return head;
    }
}
