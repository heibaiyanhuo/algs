
const TreeNode = require('./datastructure').TreeNode;

var splitBST = function(root, V) {
    
    if (root.val <= V) {
        let bt = root.right;
        root.right = null;
        return [root, bt];
    }
    let p = root;
    while (p.left && p.left.val > V) {
        p = p.left;
    }
    let st = p.left;
    let [sst, bst] = splitBST(st.right, V);
    st.right = sst;
    p.left = bst;
    return [st, root];    
};