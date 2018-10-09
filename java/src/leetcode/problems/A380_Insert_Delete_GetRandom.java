package leetcode.problems;

import java.util.*;

public class A380_Insert_Delete_GetRandom {

    List<Integer> nums;
    Map<Integer, Integer> pos;
    Random r = new Random();

    public A380_Insert_Delete_GetRandom() {
        nums = new ArrayList<>();
        pos = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (pos.containsKey(val)) {
            return false;
        }
        pos.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!pos.containsKey(val)) {
            return false;
        }
        int position = pos.get(val);
        if (position < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int last = nums.get(nums.size() - 1 );
            nums.set(position , last);
            pos.put(last, position);
        }
        pos.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(r.nextInt(nums.size() - 1));
    }
}
