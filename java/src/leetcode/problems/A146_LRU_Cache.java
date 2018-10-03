package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class A146_LRU_Cache {

    private static class DN {
        int key;
        int val;
        DN next;
        DN prev;
        DN(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Map<Integer, DN> map;
    DN head;
    DN tail;

    public A146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new DN(0, 0);
        tail = new DN(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DN node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DN node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                map.remove(pop().key);
            }
            node = new DN(key, value);
            addNode(node);
            map.put(key, node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DN node) {
        remove(node);
        addNode(node);
    }

    private void addNode(DN node) {
        DN n = head.next;
        head.next = node;
        node.prev = head;
        node.next = n;
        n.prev = node;
    }

    private void remove(DN node) {
        DN prev = node.prev;
        DN next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private DN pop() {
        DN node = tail.prev;
        remove(node);
        return node;
    }
}
