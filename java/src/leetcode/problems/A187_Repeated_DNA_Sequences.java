package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A187_Repeated_DNA_Sequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> seen = new HashSet<>();
        int i = 0, j = 10;
        while (j <= s.length()) {
            String seq = s.substring(i++, j++);
            if (seen.contains(seq)) {
                res.add(seq);
            } else {
                seen.add(seq);
            }
        }
        return new ArrayList<>(res);
    }
}
