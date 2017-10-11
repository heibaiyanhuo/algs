/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

const ListNode = require('../datastructure/ListNode');

var addTwoNumbers = (l1, l2) => {
    let p1 = l1, p2 = l2;
    let result = new ListNode(0);

    let p = result, carry = 0;
    while (p1 || p2) {
        let valp1 = p1 ? p1.val : 0;
        let valp2 = p2 ? p2.val : 0;
        let sum = carry + valp1 + valp2;
        carry = sum > 10 ? 1 : 0;
        p.next = new ListNode(sum%10);
        p = p.next;
        if (p1) p1 = p1.next;
        if (p2) p2 = p2.next;
    }
    if (carry > 0) {
        p.next = new ListNode(1)
    }
    return result.next;
}

console.log(addTwoNumbers(new ListNode(3), new ListNode(4)).val)
