package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;


public class A345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        char[] a = s.toCharArray();
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'o', 'i', 'u', 'A', 'E', 'O', 'I', 'U'));
        int lo = 0;
        int hi = a.length - 1;

        while (lo < hi) {
            while (lo < hi && !set.contains(a[lo])) {
                lo++;
            }
            while (hi > lo && !set.contains(a[hi])) {
                hi--;
            }
            if (lo < hi) {
                char tmp = a[lo];
                a[lo] = a[hi];
                a[hi] = tmp;
            }
            lo++;
            hi--;
        }

        return new String(a);
    }

    public static void main(String[] args) {
        A345_Reverse_Vowels_of_a_String solution = new A345_Reverse_Vowels_of_a_String();
        System.out.println(solution.reverseVowels("leetcode"));
    }
}
