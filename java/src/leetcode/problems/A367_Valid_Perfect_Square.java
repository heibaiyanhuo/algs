package leetcode.problems;

public class A367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return true;
        }
        int n = 1;
        while (n < num / n) {
            n++;
        }
        return n == num / n;
    }

}
