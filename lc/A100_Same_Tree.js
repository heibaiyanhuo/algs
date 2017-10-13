/**
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*/

const isSameTree = (p, q) => {
  if (p && q) {
    return p.val === q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  } else if (!p && !q) {
    return true;
  } else {
    return false;
  }
}