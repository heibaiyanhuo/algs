/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */

const inorderTraversal = (root) => {
    // recursion
    const ret = [];
    const traversal = (node) => {
        if (node) {
            if (node.left) traversal(node.left);    
            ret.push(node.val);
            if (node.right) traversal(node.right);
        }
    }
    traversal(root);
    return ret;
}

const it = (root) => { 
    const ret = [];
    const stack = [];

    let p = root;
    while (p || stack.length > 0) {
        while (p) {
            stack.push(p);
            p = p.left;
        }
        p = stack.pop();
        ret.push(p.val);
        p = p.right;
    }
    return ret;
}