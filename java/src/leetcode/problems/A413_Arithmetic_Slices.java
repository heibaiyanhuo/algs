package leetcode.problems;

public class A413_Arithmetic_Slices {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 2; i < A.length; i++) {
            int d = A[i] - A[i - 1];
            int j = i - 1;
            int count = 0;
            while (j > 0 && A[j] - A[j- 1] == d) {
                count++;
                j--;
            }
            res += count;
        }
        return res;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int[] dp = new int[A.length];
        dp[0] = 0;
        dp[1] = 0;
        int dPrev = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            int dCurr = A[i] - A[i - 1];
            if (dCurr == dPrev) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
            dPrev = dCurr;
        }
        int res = 0;
        for (int number: dp) {
            res += number;
        }

        return res;
    }

    public int numberOfArithmeticSlices3(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int dPrev = A[1] - A[0];
        int count = 0; // number of arithmetic slices at the last index
        int res = 0; // final result
        for (int i = 2; i < A.length; i++) {
            int dCurr = A[i] - A[i - 1];
            if (dCurr == dPrev) {
                count += 1;
            } else {
                count = 0;
            }
            dPrev = dCurr;
            res += count;
        }

        return res;
    }

    public static void main(String[] args) {
        A413_Arithmetic_Slices solution = new A413_Arithmetic_Slices();
        System.out.println(solution.numberOfArithmeticSlices3(new int[]{1, 2, 3}));
    }
}
