/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */
const TreeNode = require('./datastructure').TreeNode;

const isValidBST = (root) => {
    const _isValid = (node, min, max) => {
        if (!node) return true;
        if (node.val <= min || node.val >= max) return false;
        return _isValid(node.left, min, node.val) && _isValid(node.right, node.val, max);
    }
    return _isValid(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
}

const isValidBST2 = (root) => {
    // iterative
    const stack = [];
    let p = root;
    let prev = null;
    while (p || stack.length > 0) {
        while (p) {
            stack.push(p);
            p = p.left;
        }
        p = stack.pop();
        if (prev && p.val <= prev.val) return false;
        prev = p;
        p = p.right;
    }
    return true;
}

const n0 = new TreeNode(3);
const n1 = new TreeNode(30);
const n2 = new TreeNode(10);
const n3 = new TreeNode(15);
const n4 = new TreeNode(45);
n0.right = n1;
n1.left = n2;
n2.right = n3;
n3.right = n4;

console.log(isValidBST(n0))