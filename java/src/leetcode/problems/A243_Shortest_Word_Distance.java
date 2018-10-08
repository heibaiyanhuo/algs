package leetcode.problems;

public class A243_Shortest_Word_Distance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int d = words.length;
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (idx2 > -1) {
                    d = Math.min(i - idx2, d);
                }
                idx1 = i;
            } else if (words[i].equals(word2)) {
                if (idx1 > -1) {
                    d = Math.min(i - idx1, d);
                }
                idx2 = i;
            }
        }
        return d;
    }

}
