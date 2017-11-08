const ListNode = require('../datastructure').ListNode

const arrayToLinkedList = (arr) => {
    let dummyHead = new ListNode();
    let p = dummyHead;
    for (let val of arr) {
        p.next = new ListNode(val);
        p = p.next;
    }
    return dummyHead.next;
}

const showLinkedList = (head) => {
    let p = head;
    while (p) {
        // console.log(p.val);
        process.stdout.write(p.val + ', ');
        p = p.next;
    }
    process.stdout.write('\n');
}

module.exports = {
    arrayToLinkedList,
    showLinkedList
}