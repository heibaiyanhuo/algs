package leetcode.problems;

import leetcode.datastructures.ListNode;

public class A206_Reverse_Linked_List {

    public ListNode reverseList(ListNode head) {

        ListNode rev = null;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = rev;
            rev = p;
            p = tmp;
        }

        return rev;
    }

    public ListNode reverseList_recursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode rev = reverseList_recursive(nextNode);
        nextNode.next = head;
        head.next = null;
        return rev;
    }
}
