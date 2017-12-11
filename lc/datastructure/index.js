class ListNode {
    constructor (val = 0) {
        this.val = val;
        this.next = null;
    }
}

class TreeNode {
    constructor(val = 0) {
        this.val = val;
        this.left = this.right = null;
    }
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