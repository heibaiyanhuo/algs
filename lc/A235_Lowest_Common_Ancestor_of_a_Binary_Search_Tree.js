/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 */


const lowestCommonAncestor = (root, p, q) => {
    if (root.val < Math.min(p.val, q.val)) return lowestCommonAncestor(root.right, p, q);
    if (root.val > Math.max(p.val, q.val)) return lowestCommonAncestor(root.left, p, q);
    return root;
}