const ListNode = function (val) {
    this.val = val;
    this.next = null;
}

const TreeNode = function (val) {
    this.val = val;
    this.left = this.right = null;
}


module.exports = {
    ListNode,
    TreeNode
}