package leetcode.problems;

public class A744_Find_Smallest_Letter_Greater_Than_Target {

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }

        int lo = 0;
        int hi = letters.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                if (letters[mid - 1] <= target) {
                    return letters[mid];
                } else {
                    hi = mid - 1;
                }
            }
        }
        if (lo == hi) {
            return letters[lo];
        }
        return letters[lo] > target ? letters[lo] : letters[lo + 1];
    }
}
