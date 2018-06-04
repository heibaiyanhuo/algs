/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

const ListNode = require('./datastructure').ListNode;

const mergeKLists = (lists) => {
    let dummy = new ListNode();
    let p = dummy, pointers = [];
    for (let i = 0; i < lists.length; i++) {
        pointers[i] = lists[i];
    }

    pointers.sort((p1, p2) => p1.val - p2.val);
    while (pointers.length > 1) {
        p.next = pointers[0];
        p = p.next;
        pointers[0] = pointers[0].next;
        if (!pointers[0]) pointers.splice(0, 1);
        for (let i = 1; i < pointers.length; i++) {
            if (pointers[i].val < pointers[i - 1].val) [pointers[i], pointers[i - 1]] = [pointers[i - 1], pointers[i]];
            else break;
        }
    }
    p.next = pointers[0];
};