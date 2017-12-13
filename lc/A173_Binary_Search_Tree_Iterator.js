/**
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

class BSTIterator {
    constructor(root) {
        this.stack = [];
        let p = root;
        while (p) {
            this.stack.push(p);
            p = p.left;
        }
    }
    hasNext() {
        return this.stack.length > 0;
    }
    next() {
        let curr = this.stack.pop();
        let p = curr.right;
        while (p) {
            this.stack.push(p);
            p = p.left;
        }
        return curr.val;
    }
}