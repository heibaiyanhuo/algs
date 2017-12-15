/**
 * Reverse a singly linked list.
 */
const ListNode = require('./utils').ListNode;
const arrTo = require('./utils').arrayToLinkedList;
const showList = require('./utils').showLinkedList;

// iterative
const reverseList = (head) => {
    let rev = null;
    let p = head;
    while (p) {
        [rev, rev.next, p] = [p, rev, p.next];
        // let next = p.next;
        // p.next = rev;
        // rev = p;
        // p = next;
    }
    return rev;
}

// recursive
const reverseList2 = (head) => {
    if (!head || !head.next) return head;
    let nextNode = head.next;
    let rev = reverseList2(nextNode);
    nextNode.next = head;
    head.next = null;
    return rev;
}
showList(reverseList2(arrTo([1, 2, 4, 3, 5])))
