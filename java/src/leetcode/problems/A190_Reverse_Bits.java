package leetcode.problems;

public class A190_Reverse_Bits {

    public int reverseBits(int n) {
        int val = 0;

        for (int i = 0; i < 32; i++) {
            int lastBit = n & 1;
            val ^= lastBit;
            if (i < 31) {
                n >>= 1;
                val <<= 1;
            }
        }

        return val;
    }

    public static void main(String[] args) {
        A190_Reverse_Bits solution = new A190_Reverse_Bits();

        System.out.println(solution.reverseBits(2));
//        System.out.println(1 << 31);
    }
}
