package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class A210_Course_Schedule_II {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
            visited[i] = 0;
        }
        for (int[] edge: prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCircle(res, graph, visited, i)) {
                return new int[0];
            }
        }
        int[] ret = new int[numCourses];
        int j = 0;
        for (int i = numCourses - 1; i >= 0; i--) {
            ret[i] = res.get(j++);
        }
        return ret;
    }

    private boolean hasCircle(List<Integer> res, List<List<Integer>> graph, int[] visited, int curr) {
        visited[curr] = 1;
        for (Integer neighbor: graph.get(curr)) {
            if (visited[neighbor] == 1) {
                return true;
            }
            if (visited[neighbor] == 0 && hasCircle(res, graph, visited, neighbor)) {
                return true;
            }
        }
        visited[curr] = 2;
        res.add(curr);
        return false;
    }
}
