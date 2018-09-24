package leetcode.problems;

public class A246_Strobogrammatic_Number {

    public boolean isStrobogrammatic(String num) {
        char[] map = new char[]{'0', '1', '#', '#', '#', '#', '9', '#', '8', '6'};
        int s = 0, e = num.length() - 1;
        while (s <= e) {
            if (map[num.charAt(s++) - '0'] != num.charAt(e--)) {
                return false;
            }
        }
        return true;
    }
}
