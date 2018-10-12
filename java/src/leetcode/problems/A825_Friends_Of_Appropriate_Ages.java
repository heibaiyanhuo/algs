package leetcode.problems;

public class A825_Friends_Of_Appropriate_Ages {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] numOfages = new int[121];
        int[] sum = new int[121];
        for (int age: ages) {
            numOfages[age]++;
        }
        for (int i = 1; i <= 120; i++) {
            sum[i] = numOfages[i] + sum[i - 1];
        }
        for (int i = 15; i <= 120; i++) {
            int count = sum[i] - sum[i / 2 + 7];
            res += count * numOfages[i] - numOfages[i];
        }
        return res;
    }
}
