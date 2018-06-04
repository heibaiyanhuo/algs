/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 */

const zigzagLevelOrder = (root) => {
    if (!root) return [];
    let ret = [];
    let queue = [root];
    let right = false;
    while (queue.length > 0) {
        right = !right;
        let levelLength = queue.length;
        let levelArr = new Array(levelLength);
        for (let i = 0; i < levelLength; i++) {
            let curr = queue.shift();
            if (curr.left) queue.push(curr.left);
            if (curr.right) queue.push(curr.right);
            levelArr[right ? i : levelLength - 1 - i] = curr.val;
        }
        ret.push(levelArr);
    }
    return ret;
}