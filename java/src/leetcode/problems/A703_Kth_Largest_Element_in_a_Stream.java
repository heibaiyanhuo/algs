package leetcode.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class A703_Kth_Largest_Element_in_a_Stream {

    Queue<Integer> heap;
    int k;
    public A703_Kth_Largest_Element_in_a_Stream(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for (int n: nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
