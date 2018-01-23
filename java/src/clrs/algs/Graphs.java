package clrs.algs;

import clrs.datastructures.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graphs {

    public class DFS {

        private boolean[] marked;

        public DFS(Graph G, int s) {
            marked = new boolean[G.V()];
            dfs(G, s);
        }

        private void dfs(Graph G, int v) {
            marked[v] = true;
            for (int w: G.adj(v)) {
                if (!marked[w]) {
                    dfs(G, w);
                }
            }
        }
    }

    public class BFS {

        private boolean[] marked;

        public BFS(Graph G, int s) {
            marked = new boolean[G.V()];
            bfs(G, s);
        }

        private void bfs(Graph G, int s) {
            Queue<Integer> queue = new LinkedList<>();
            marked[s] = true;
            queue.offer(s);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int w: G.adj(v)) {
                    if (!marked[w]) {
                        marked[w] = true;
                        queue.offer(w);
                    }
                }
            }
        }
    }
}
