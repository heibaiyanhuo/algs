package leetcode.problems;

import leetcode.datastructures.ListNode;

public class A082_Remove_Duplicates_from_Sorted_List_II {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            ListNode q = p.next;
            while (q.next != null && q.val == q.next.val) {
                q = q.next;
            }

            if (q != p.next) {
                p.next = q.next;
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }
}
