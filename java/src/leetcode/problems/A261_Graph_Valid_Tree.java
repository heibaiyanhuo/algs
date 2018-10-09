package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A261_Graph_Valid_Tree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> E = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            E.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            E.get(edge[0]).add(edge[1]);
            E.get(edge[1]).add(edge[0]);
        }
        if (hasCycle(0, E, visited, -1)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean hasCycle(int n, List<List<Integer>> E, Set<Integer> visited, int parent) {
        if (visited.contains(n)) {
            return true;
        }
        visited.add(n);
        for (Integer i: E.get(n)) {
            if (i == n || (parent != i && hasCycle(i, E, visited, n))) {
                return true;
            }
        }
        return false;
    }
}
