/**
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */


var swapPairs = function(head) {
    if (!head) return null;
    let p1 = head, p2 = p1.next;
    if (!p2) return p1;
    let p3 = p2.next;
    p2.next = p1;
    p1.next = swapPairs(p3);
    return p2;
};