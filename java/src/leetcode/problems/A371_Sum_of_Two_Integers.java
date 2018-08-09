package leetcode.problems;

public class A371_Sum_of_Two_Integers {

    private int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }


    public static void main(String[] args) {
        A371_Sum_of_Two_Integers solution = new A371_Sum_of_Two_Integers();
        System.out.println(solution.getSum(1, 1));
    }
}
