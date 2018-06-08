package leetcode.problems;

public class A172_Factorial_Trailing_Zeroes {

    public int trailingZeroes(int n) {
        int count = 0;
        while (true) {
            int tmp = n / 5;
            if (tmp == 0) {
                break;
            }
            count += tmp;
            n /= 5;
        }
        return count;
//        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        A172_Factorial_Trailing_Zeroes solution = new A172_Factorial_Trailing_Zeroes();
        System.out.println(solution.trailingZeroes(20));
    }
}
