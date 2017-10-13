/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */


var isSymmetric = function(root) {
    if (!root) return true;
    return isSymSameTree(root.left, root.right);
};

const isSymSameTree = (t1, t2) => {
    if (t1.val !== t2.val) return false;
    if (t1 && t2) {
        return isSymSameTree(t1.left, t2.right) && isSymSameTree(t1.right, t2.left);
    } else if (!t1 && !t2) {
        return true;
    } else {
        return false;
    }
}