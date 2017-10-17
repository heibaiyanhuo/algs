const ListNode = function (val) {
    this.val = val;
    this.next = null;
}

const TreeNode = function (val) {
    this.val = val;
    this.left = this.right = null;
}

const Interval = function (start, end) {
    this.start = start;
    this.end = end;
}


module.exports = {
    ListNode,
    TreeNode,
    Interval
}