const ListNode = require('./datastructure').ListNode;

const att = require('./utils').arrayToLinkedList;
const sh = require('./utils').showLinkedList;

const mergeTwoLists = (l1, l2) => {
    let dummyHead = new ListNode();
    let p1 = l1, p2 = l2, p = dummyHead;

    while (true) {
        if (!p1) {
            p.next = p2;
            return dummyHead.next;
        }
        if (!p2) {
            p.next = p1;
            return dummyHead.next;
        }
        if (p1.val < p2.val) {
            p.next = p1;
            p1 = p1.next;
        } else {
            p.next = p2;
            p2 = p2.next;
        }
        p = p.next;
    }
}

const mergeTwoListsInPlace = (l1, l2) => {
    if (!l1 || !l2) return l1 || l2;
    let dummyHead = new ListNode();
    let p = dummyHead;
    dummyHead.next = l1;
    while (l1 && l2) {
        if (l1.val < l2.val) {
            l1 = l1.next;
        } else {
            nxt = p.next;
            p.next = l2;
            tmp = l2.next;
            l2.next = nxt;
            l2 = tmp;
        }
        p = p.next;
    }
    p.next = l1 || l2;
    return dummyHead.next;
}


l1 = att([2, 3, 4, 5, 6]);
l2 = att([3,4,5,6,7]);
// sh(mergeTwoLists(l1, l2));
sh(mergeTwoListsInPlace(l1, l2))