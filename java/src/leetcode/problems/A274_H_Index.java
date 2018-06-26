package leetcode.problems;

public class A274_H_Index {

    private int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int N = citations.length;
        int[] aux = new int[N + 1];
        for (int n: citations) {
            aux[Math.min(n, N)] += 1;
        }
        int sum = 0;
        for (int i = N; i >= 0; i--) {
            sum += aux[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        A274_H_Index solution = new A274_H_Index();
        int[] a = {0,1,2};
        System.out.println(solution.hIndex(a));
    }
}
