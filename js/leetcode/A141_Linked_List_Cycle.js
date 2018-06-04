/*
*
Given a linked list, determine if it has a cycle in it.
*/

var hasCycle = function(head) {
    let sl = head, fa = head;

    while (sl && fa && fa.next) {
        sl = sl.next;
        fa = fa.next.next;
        if (sl == fa) return true
    }
    return false;
};