package leetcode.problems;

public class A029_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? -1 : 0;
        }
        int sign = 1;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            dividend = Math.abs((dividend >> 1));
            if (divisor < 0) {
                sign = -1;
                divisor = -divisor;
            }
            int tmp = helper(dividend, divisor);
            int r = dividend - tmp * divisor;
            if (r - divisor + r > 0) {
                return sign * ((tmp << 1) + 1);
            } else {
                return sign * (tmp << 1);
            }
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        return sign * helper(dividend, divisor);
    }

    private int helper(int dividend, int divisor) {
        if (divisor > dividend) {
            return 0;
        }
        int res = 0;
        while (dividend >= divisor) {
            int p = divisor;
            int muti = 1;
            while (p <= (dividend >> 1)) {
                muti <<= 1;
                p <<= 1;
            }
            res += muti;
            dividend -= p;
        }
        return res;
    }

    public static void main(String[] args) {
        A029_Divide_Two_Integers solution = new A029_Divide_Two_Integers();
        System.out.println(solution.divide(-2147483648, -2));
    }
}
