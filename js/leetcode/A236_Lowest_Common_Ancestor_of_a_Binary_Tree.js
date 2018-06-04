/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 */

const TreeNode = require('./datastructure').TreeNode;



const lowestCommonAncestor = (root, p, q) => {
    if (root === null || root === p || root === q) return root;
    const left = lowestCommonAncestor(root.left, p, q);
    const right = lowestCommonAncestor(root.right, p, q);
    if (left && right) return root;
    return left || right;
}

const n1 = new TreeNode(1);
const n2 = new TreeNode(2);
const n3 = new TreeNode(3);
n1.left = n2;
n1.right = n3;

console.log(lowestCommonAncestor(n1, n2, n3).val);