/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */

const kthSmallest = function(root, k) {
    const stack = [];
    let p = root;
    while (p || stack.length > 0) {
        while (p) {
            stack.push(p);
            p = p.left;
        }
        p = stack.pop();
        if (--k === 0) break;
        p = p.right;
    }
    return p.val;
};