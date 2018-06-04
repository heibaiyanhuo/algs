/**
 * Given a singly linked list, determine if it is a palindrome.
 */


var isPalindrome = function(head) {
    let rev = null;
    let slow = head, fast = head;
    while (fast && fast.next) {
        fast = fast.next.next;
        [rev, rev.next, slow] = [slow, rev, slow.next];
    }
    if (fast) {
        slow = slow.next;
    }
    while (rev && rev.val === slow.val) {
        rev = rev.next;
        slow = slow.next;
    }
    return rev === null;
}; 