package leetcode.problems;

/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 */

public class A008_String_to_Integer {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int originalLength = str.length();

        int result = 0;
        int p = 0;
        int sign = 1;
        while (p < originalLength && str.charAt(p) == ' ') {
            p++;
        }
        if (p == originalLength) {
            return 0;
        }

        if (str.charAt(p) == '-') {
            sign = -1;
            p++;
        } else if (str.charAt(p) == '+') {
            p++;
        }

        if (p == originalLength || str.charAt(p) < '0' || str.charAt(p) > '9') {
            return 0;
        }

        while (p < originalLength && str.charAt(p) == '0') {
            p++;
        }
        if (p == originalLength) {
            return 0;
        }

        while (p < originalLength && str.charAt(p) >= '0' && str.charAt(p) <= '9') {
            int rest = str.charAt(p) - '0';

            if (result > 214748364 || (result == 214748364 && rest > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + rest;
            p++;
        }

        return sign * result;

    }

    public static void main(String[] args) {
        A008_String_to_Integer solution = new A008_String_to_Integer();
        System.out.println(solution.myAtoi("-42"));
    }
}
