package leetcode.problems;

public class A151_Reverse_Words_in_a_String {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]).append(" ");
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }
}
