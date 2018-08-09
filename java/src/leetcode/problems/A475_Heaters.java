package leetcode.problems;

import java.util.Arrays;

public class A475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = Integer.MIN_VALUE;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            int idx = findCloset(heaters, houses[i]);
            radius = Math.max(radius, Math.abs(heaters[idx] - houses[i]));
        }

        return radius;
    }

    private int findCloset(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                if (numbers[mid - 1] > target) {
                    hi = mid - 1;
                } else {
                    return numbers[mid] - target < target - numbers[mid - 1] ? mid : mid - 1;
                }
            } else {
                if (numbers[mid + 1] < target) {
                    lo = mid + 1;
                } else {
                    return numbers[mid + 1] - target < target - numbers[mid] ? mid + 1: mid;
                }
            }
        }
        if (lo == hi) {
            return lo;
        }
        return Math.abs(numbers[lo] - target) < Math.abs(numbers[lo + 1] - target) ? lo : lo + 1;
    }

    public static void main(String[] args) {
        A475_Heaters solution = new A475_Heaters();
//        int[] test = new int[]{1, 3, 4, 5, 8, 9, 15, 20};
        int[] test = new int[]{2};
        System.out.println(test[solution.findCloset(test, 1)]);
    }
}
