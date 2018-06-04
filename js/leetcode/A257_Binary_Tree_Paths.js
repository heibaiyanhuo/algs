/**
 * Given a binary tree, return all root-to-leaf paths.
 */

const binaryTreePaths = (root) => {
    if (!root) return [];
    let ret = [];
    let path = '';
    const dfs = (path, node) => {
        if (!node.left && !node.right) {
            ret.push(path + node.val);
        } else {
            path += (node.val + '->');
            if (node.left) {
                dfs(path, node.left);
            }
            if (node.right) {
                dfs(path, node.right);
            }
        }
    }
    dfs('', root);
    return ret;
}