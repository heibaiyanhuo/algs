package leetcode.problems;

import leetcode.datastructures.ListNode;

public class A203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        A203_Remove_Linked_List_Elements solution = new A203_Remove_Linked_List_Elements();
        ListNode node = solution.removeElements(head, 2);
        System.out.println(node.val);
    }
}
