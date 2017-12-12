/**
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
 */

const verticalOrder = (root) => {
    if (!root) return [];
    const nq = [root];
    const cq = [0];
    const map = new Map();
    let min = 0, max = 0;
    while (nq.length > 0) {
        const curr = nq.shift();
        const col = cq.shift();
        if (!map.has(col)) {
            map.set(col, [curr.val]);
        } else {
            map.get(col).push(curr.val);
        }
        if (curr.left) {
            nq.push(curr.left);
            cq.push(col - 1);
            min = Math.min(min, col - 1);
        }
        if (curr.right) {
            nq.push(curr.right);
            cq.push(col + 1);
            max = Math.max(max, col + 1);
        }
    }
    let ret = [];
    for (let i = min; i <= max; i++) {
        ret.push(map.get(i));
    }
    return ret;
}