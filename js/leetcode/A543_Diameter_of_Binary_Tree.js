/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 */

const diameterOfBinaryTree = (root) => {
    let max = 0;
    const maxDepth = (node) => {
        if (!node) return 0;
        let left = maxDepth(node.left);
        let right = maxDepth(node.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
    maxDepth(root);
    return max;
}