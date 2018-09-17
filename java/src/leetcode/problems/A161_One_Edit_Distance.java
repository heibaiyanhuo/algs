package leetcode.problems;

public class A161_One_Edit_Distance {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        int sl = s.length(), tl = t.length();
        int min = Math.min(sl, tl);
        for (int i = 0; i < min; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sl == tl) return s.substring(i + 1).equals(t.substring(i + 1));
                if (sl > tl) return s.substring(i + 1).equals(t.substring(i));
                return s.substring(i).equals(t.substring(i + 1));
            }
        }

        return Math.abs(sl - tl) == 1;
    }
}
