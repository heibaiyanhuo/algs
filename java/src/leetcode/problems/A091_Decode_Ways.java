package leetcode.problems;

public class A091_Decode_Ways {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int a = 1, b = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = a;
            a = (s.charAt(i) > '0' ? a : 0) + b + (s.charAt(i) < '7' ? c : 0);
            b = s.charAt(i) == '1' ? tmp : 0;
            c = s.charAt(i) == '2' ? tmp : 0;
        }
        return a;
    }
}
