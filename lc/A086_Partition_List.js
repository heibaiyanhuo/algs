/**
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
 */
const ListNode = require('./datastructure').ListNode;

const arrTo = require('./utils').arrayToLinkedList;
const showList = require('./utils').showLinkedList;

var partition = function(head, x) {
    let dummy1 = new ListNode(), dummy2 = new ListNode();
    let p1 = dummy1, p2 = dummy2, p = head;
    while (p) {
        if (p.val < x) {
            p1.next = p;
            p1 = p1.next;
        } else {
            p2.next = p;
            p2 = p2.next;
        }
        p = p.next;
    }
    p2.next = null;
    p1.next = dummy2.next;
    return dummy1.next;
};


const p2 = (head, x) => {
    if (head === null) return head;
    let dummy1 = new ListNode(), dummy2 = new ListNode();
    let p = dummy1, q = dummy2;
    dummy1.next = head;
    while (p) {
        let p1 = p;
        while (p1.next && p1.next.val >= x) {
            q.next = p1.next;
            q = q.next;
            p1 = p1.next;
        }
        p.next = p1.next;
        if (!p.next) {
            q.next = null;
            p.next = dummy2.next;
            break;
        } else {
            p = p.next;
        }
    }
    return dummy1.next;
}
showList(p2(arrTo([1]), 0))
