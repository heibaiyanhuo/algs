package leetcode.problems;

import java.util.Stack;

/**
 * A stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class A155_Min_Stack {
//    Stack<Integer> data;
//    Stack<Integer> minimal;
//
//    public A155_Min_Stack() {
//        data = new Stack<>();
//        minimal = new Stack<>();
//    }
//
//    public void push(int x) {
//        data.push(x);
//        if (minimal.isEmpty() || minimal.peek() >= x) {
//            minimal.push(x);
//        }
//    }
//
//    public void pop() {
//        if (!data.isEmpty()) {
//            int tmp = data.pop();
//            if (tmp == minimal.peek()) {
//                minimal.pop();
//            }
//        }
//    }
//
//    public int top() {
//        return data.peek();
//    }
//
//    public int getMin() {
//        return minimal.peek();
//    }

    private Node head;

    public A155_Min_Stack() {
        head = null;
    }

    public void push(int x) {
        if (head == null) {
            Node node = new Node(x, x, head);
            head = node;
        } else {
            Node node = new Node(x, Math.min(x, head.currMin), head);
            head = node;
        }
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.currMin;
    }

    class Node {
        int val;
        int currMin;
        Node next;

        Node(int val, int currMin, Node next) {
            this.val = val;
            this.currMin = currMin;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        A155_Min_Stack ms = new A155_Min_Stack();
        ms.push(5);
        ms.push(3);
        ms.push(3);
        ms.push(4);
        ms.push(2);
        System.out.println(ms.top());
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
