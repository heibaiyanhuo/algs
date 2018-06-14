package leetcode.problems;

public class A441_Arranging_Coins {
    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == Integer.MAX_VALUE) {
            return 65535;
        }
        int rangeLeft = (int) Math.ceil(-1 + Math.sqrt(2) * Math.sqrt(n));
        System.out.println(rangeLeft);
        int rangeRight = (int) Math.floor(1 + Math.sqrt(2) * Math.sqrt(n + 1));
        System.out.println(rangeRight);
        for (int i = rangeLeft; i <= rangeRight; i++) {
            if ((i & 1) == 1) {
                if (n / i < (i + 1) / 2) {
                    return i - 1;
                }
            } else {
                if (n / (i + 1) < i / 2) {
                    return i - 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        A441_Arranging_Coins solution = new A441_Arranging_Coins();
        System.out.println(solution.arrangeCoins(4));
    }
}
