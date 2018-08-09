package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class A225_Implement_Stack_using_Queues {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public A225_Implement_Stack_using_Queues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> data = q1.isEmpty() ? q2 : q1;
        data.offer(x);
    }

    public int pop() {
        Queue<Integer> data, aux;
        if (q1.isEmpty()) {
            aux = q1;
            data = q2;
        } else {
            aux = q2;
            data = q1;
        }
        while (data.size() != 1) {
            aux.offer(data.poll());
        }
        return data.poll();
    }

    public int top() {
        Queue<Integer> data, aux;
        if (q1.isEmpty()) {
            aux = q1;
            data = q2;
        } else {
            aux = q2;
            data = q1;
        }
        while (data.size() != 1) {
            aux.offer(data.poll());
        }
        int res = data.peek();
        aux.offer(data.poll());
        return res;

    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
