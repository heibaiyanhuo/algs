/**
Given a list, rotate the list to the right by k places, where k is non-negative.
 */

const rotateRight = (head, k) => {
    if (k === 0) return head;
    let p = head;
    let length = 0;
    let tail;
    while (!p) {
        if (!p.next) tail = p;
        p = p.next;
        length++;
    }
    let i = length - k;
    p = head;
    let start;
    while (i-- > 0) {
        p = p.next;
    }
    let result = p.next;

    tail.next = head;
    p.next = null;
    return result;
}