const TreeNode = require('./datastructure').TreeNode;

const serialize1 = (root) => {
    let res = '';
    const buildString = (node) => {
        if (!node) {
            res += 'N,';
        } else {
            res += `${node.val},`
            buildString(node.left);
            buildString(node.right);
        }
    }
    buildString(root);
    return res;
}

const deserialize1 = (data) => {
    let queue = data.split(',');
    const buildTree = (strs) => {
        let str = strs.shift();
        if (str === 'N') return null;
        let tn = new TreeNode(~~str);
        tn.left = buildTree(strs);
        tn.right = buildTree(strs);
        return tn;
    }
    return buildTree(queue);
}