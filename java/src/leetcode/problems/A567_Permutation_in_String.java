package leetcode.problems;

public class A567_Permutation_in_String {

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)]++;
        }
        int l = s1.length();
        int sp = 0, ep = 0;
        while (ep < s2.length()) {
            if (map[s2.charAt(ep++)]-- > 0) l--;
            while (l == 0) {
                if (ep - sp == s1.length()) {
                    return true;
                }
                if (map[s2.charAt(sp++)]++ == 0) l++;
            }
        }
        return false;
    }
}
