package leetcode.problems;

public class A076_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }
        int counter = t.length();
        int bp = 0, ep = 0, head = 0, l = Integer.MAX_VALUE;
        while (ep < s.length()) {
            if (freq[s.charAt(ep++)]-- > 0) counter--;
            while (counter == 0) {
                int currLength = ep - bp;
                if (currLength < l) {
                    l = currLength;
                    head = bp;
                }
                if (freq[s.charAt(bp++)]++ == 0) counter++;
            }
        }
        return l == Integer.MAX_VALUE ? "" : s.substring(head, head + l);
    }
}
