package leetcode.problems;


public class A785_Is_Graph_Bipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !isValidComponent(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidComponent(int[][] graph, int[] colors, int color, int idx) {
        if (colors[idx] == 0) {
            colors[idx] = color;
            for (int i: graph[idx]) {
                if (!isValidComponent(graph, colors, -color, i)) {
                    return false;
                }
            }
            return true;
        }
        if (colors[idx] != color) {
            return false;
        }
        return true;
    }
}
