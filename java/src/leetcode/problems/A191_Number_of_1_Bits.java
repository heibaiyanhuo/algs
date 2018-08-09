package leetcode.problems;

public class A191_Number_of_1_Bits {

    public int hammingWeight(int n) {
        int count = 0;
        for (; n > 0; count++) {
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        A191_Number_of_1_Bits solution = new A191_Number_of_1_Bits();
        System.out.println(solution.hammingWeight(128));
    }
}
