package leetcode.problems;

import java.util.Arrays;

public class A043_Multiply_Strings {

    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        if (l1 == 0) {
            return num2;
        }
        if (l2 == 0) {
            return num1;
        }
        char[] res = new char[l1 + l2];
        Arrays.fill(res, '0');
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int offset = l1 + l2 - 2 - i - j;
                int muti = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                if (muti < 10) {
                    add(res, offset, muti);
                } else {
                    add(res, offset, muti % 10);
                    add(res, offset + 1, muti / 10);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int p = l1 + l2 - 1;
        while (p > 0 && res[p] == '0') {
            p--;
        }
        while (p >= 0) {
            sb.append(res[p--]);
        }
        return sb.toString();
    }

    private void add(char[] res, int offset, int units) {
        int carry = 0;
        while (offset < res.length) {
            int origin = res[offset] - '0';
            int tmp = origin + units + carry;
            if (tmp < 10) {
                res[offset] = (char) (tmp + '0');
                break;
            } else {
                res[offset] = (char) (tmp - 10 + '0');
                units = 0;
                carry = 1;
                offset++;
            }
        }
    }

    public static void main(String[] args) {
        A043_Multiply_Strings solution = new A043_Multiply_Strings();
        System.out.println(solution.multiply("603", "99"));
    }

}
