package leetcode.problems;


/**
 * This is brilliant. I'll do a quick recap of the process of the construction.
 *
 * Find the most frequent chars(tasks) and use them to create Frames. We call these chars Delimiters
 * Suppose we have F Frames and F+1 Delimiters, and for simplicity, we assume the Delimiter is a char 'A'
 * Now we setup all Frames as something like this: A----A----A----A----A
 * We fill the next most frequent chars into these Frames. Keep doing this until (i) there is no remaining chars or (ii) there is no empty slot in Frames
 * Now we're done filling the Frames. We consider the remaining chars.
 *
 * (i) No remaining chars means we're done. The length of the sequence is F * length(Frame) + length(Delimiter)
 * (ii) No empty slots in Frames means we have to decide where to put the remaining chars.
 *
 * For (ii), Suppose the first char of the remaining chars is 'V', and the length of 'V's is L, with L <= F (or it'll be in the Delimiters). And there are K of them filled into the Frames at the last positions. So there are L-K 'V's left and F-K Frames containing no 'V'. Because L-K <= F-K, we can append L-K 'V' to F-K Frames without violating the rule.
 * After we fill the first remaining chars 'V', we pick the next one and append it to the Frames (length of the chars <= F) . And keep doing this until no char remains.
 * The length of the sequence for (ii) is length(chars)
 */

public class A621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int k = 0;
        int count = 0;
        int[] freq = new int[26];
        for (char t: tasks) {
            freq[t - 'A']++;
            k = Math.max(k, freq[t - 'A']);
        }
        for (int f: freq) {
            if (f == k) count++;
        }
        return Math.max((k - 1) * (n + 1) + count, tasks.length);
    }
}
