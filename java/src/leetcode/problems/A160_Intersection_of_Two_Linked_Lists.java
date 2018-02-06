package leetcode.problems;

import leetcode.datastructures.ListNode;

public class A160_Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        int count1 = 0;
        int count2 = 0;
        while (p1.next != null) {
            p1 = p1.next;
            count1++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            count2++;
        }
        if (p1 != p2) {
            return null;
        }
        p1 = headA;
        p2 = headB;
        int diff = count1 - count2;
        if (diff == 0) {
            while (true) {
                if (p1 == p2) {
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        } else if (diff > 0) {
            while (diff-- > 0) {
                p1 = p1.next;
            }
            while (true) {
                if (p1 == p2) {
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        } else {
            diff = -diff;
            while (diff-- > 0) {
                p2 = p2.next;
            }
            while (true) {
                if (p1 == p2) {
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        }

    }
}
