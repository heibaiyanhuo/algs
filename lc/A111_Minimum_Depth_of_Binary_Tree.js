/**

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

var minDepth = function(root) {
    if (!root) return 0;
   [ld, rd] = [minDepth(root.left), minDepth(root, right)];
   return 1 + (Math.min(ld, rd) || Math.max(ld, rd)); 
};