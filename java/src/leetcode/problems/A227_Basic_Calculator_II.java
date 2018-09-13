package leetcode.problems;

import java.util.Stack;

public class A227_Basic_Calculator_II {

    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        int res = 0;
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if ('0' <= c && c <= '9') {
                num = 10 * num + (c - '0');
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        numbers.push(num);
                        break;
                    case '-':
                        numbers.push(-num);
                        break;
                    case '*':
                        numbers.push(numbers.pop() * num);
                        break;
                    case '/':
                        numbers.push(numbers.pop() / num);
                        break;
                }
                num = 0;
                sign = c;
            }
        }
        while (!numbers.isEmpty()) {
            res += numbers.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        A227_Basic_Calculator_II solution = new A227_Basic_Calculator_II();
        System.out.println(solution.calculate("0-2"));
    }
}
