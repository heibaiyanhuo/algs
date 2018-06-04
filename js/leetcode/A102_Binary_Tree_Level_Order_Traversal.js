/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */

const levelOrder = (root) => {
    if (!root) return [];
    let ret = [];
    let queue = [root];
    while (queue.length > 0) {
        let levelLength = queue.length;
        let levelArr = new Array(levelLength);
        for (let i = 0; i < levelLength; i++) {
            let curr = queue.shift();
            if (curr.left) queue.push(curr.left);
            if (curr.right) queue.push(curr.right);
            levelArr[i] = curr.val;
        }
        ret.push(levelArr);
    }
    return ret;
}