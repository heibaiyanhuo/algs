package leetcode.problems;

public class A389_Find_the_Difference {

    public char findTheDifference(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res + t.charAt(i) - s.charAt(i);
        }
        res += t.charAt(t.length() - 1);
        return (char) res;
    }
}
