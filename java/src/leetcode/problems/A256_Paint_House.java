package leetcode.problems;

public class A256_Paint_House {

    public int minCost(int[][] costs) {
        int r = 0, b = 0, g = 0;
        for (int i = 0; i < costs.length; i++) {
            int prevR = r;
            int prevB = b;
            r = Math.min(b, g) + costs[i][0];
            b = Math.min(g, prevR) + costs[i][1];
            g = Math.min(prevR, prevB) + costs[i][2];
        }
        return Math.min(r, Math.min(b, g));
    }
}
