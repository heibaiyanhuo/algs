package leetcode.problems;

import leetcode.datastructures.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A023_Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(listNode -> listNode.val));
        for (ListNode list: lists) {
            if (list != null) queue.offer(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            p.next = min;
            p = p.next;
            if (min.next != null) queue.offer(min.next);
        }
        return dummy.next;
    }
}
