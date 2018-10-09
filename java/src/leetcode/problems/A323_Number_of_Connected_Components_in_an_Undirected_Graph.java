package leetcode.problems;

public class A323_Number_of_Connected_Components_in_an_Undirected_Graph {
    public int countComponents(int n, int[][] edges) {
        int count = n;
        int[] sz = new int[n];
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        for (int[] edge: edges) {
            count -= union(edge[0], edge[1], id, sz);
        }
        return count;
    }

    private int find(int p, int[] id) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    private int union(int p, int q, int[] id, int[] sz) {
        int pRoot = find(p, id);
        int qRoot = find(q, id);
        if (pRoot == qRoot) return 0;
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        return 1;
    }

}
