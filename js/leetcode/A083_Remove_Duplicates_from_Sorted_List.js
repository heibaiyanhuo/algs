/**
Given a sorted linked list, delete all duplicates such that each element appear only once.
 */

function ListNode(val) {
    this.val = val;
    this.next = null;
}

const deleteDuplicates = (head) => {
    if (head === null || head.next === null) return head;
    let p = head;
    while (p && p.next !== null) {
        if (p.val !== p.next.val) {
            p = p.next;
        } else {
            p = p.next.next;
        }
    }
    return head;
}

let head = new ListNode(0);
let n1 = new ListNode(1);
let n2 = new ListNode(1);
let n3 = new ListNode(2);

head.next = n1;
n1.next = n2;
n2.next = n3;

deleteDuplicates(head);