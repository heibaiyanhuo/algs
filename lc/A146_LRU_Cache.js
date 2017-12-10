/**
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

class DoubleListNode {
    constructor(k = null, v = null) {
        this.key = k;
        this.value = v;
        this.pre = null;
        this.post = null;
    }
}


class LRUCache {
    constructor(capacity) {
        this.capacity = capacity;
        this.cache = new Map();
        this.count = 0;

        this.head = new DoubleListNode();
        this.tail = new DoubleListNode();
        this.head.post = this.tail;
        this.tail.pre = this.head;
    }

    get(key) {
        if (this.cache.has(key)) {
            let node = this.cache.get(key);
            moveToHead(this.head, node);
            return node.value;
        }
        return -1;
    }

    put(key, value) {
        if (this.cache.has(key)) {
            let node = this.cache.get(key);
            moveToHead(this.head, node);
            node.value = value;
        } else {
            newNode = new DoubleListNode(key, value);
            this.cache.set(key, newNode);
            addNode(this.head, newNode);
            this.count++;
            if (this.count > this.capacity) {
                let tail = popTail(this.tail);
                this.cache.delete(tail.key);
                this.count--;
            }
        }
    }
}

const removeNode = (node) => {
    let pre = node.pre;
    let post = node.post;
    pre.post = post;
    post.pre = pre;
}

const addNode = (head, node) => {
    let tmp = head.post;
    tmp.pre = node;
    head.post = node;
    node.pre = head;
    node.post = tmp;
}

const moveToHead = (head, node) => {
    removeNode(node);
    addNode(head, node);
}

const popTail = (tail) => {
    let node = tail.pre;
    removeNode(node);
    return node;
}