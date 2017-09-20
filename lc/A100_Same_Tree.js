/**
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */


const isSameTree = (p, q) => {
  if (p === null) {
    return q === null;
  } else {
    if (q === null) return false;
    if (p.val === q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    } else {
      return false;
    }
  }
}