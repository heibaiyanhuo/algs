/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */

class Node {
    constructor(val, min, next = null){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

class MinStack {
    constructor() {
        this.head = null;
    }
    push(x) {
        if (!this.head) {
            this.head = new Node(x, x);
        } else {
            this.head = new Node(x, Math.min(x, this.head.min), this.head);
        }
    }
    pop() {
        this.head = this.head.next;
    }
    top() {
        return this.head.val;
    }
    getMin() {
        return this.head.min;
    }
}