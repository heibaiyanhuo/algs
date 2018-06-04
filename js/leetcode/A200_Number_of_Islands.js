/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

const numIslands = (grid) => {
    if (!grid || grid.length === 0) return 0;
    let m = grid.length, n = grid[0].length;
    let count = 0;
    
    const bfs = (i, j) => {
        if (i > m - 1 || i < 0 || j > n - 1 || j < 0 || grid[i][j] === '0' || grid[i][j] === '#') return;
        grid[i][j] = '#';
        bfs(i + 1, j);
        bfs(i, j + 1);
        bfs(i - 1, j);
        bfs(i, j - 1);
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === '1') {
                bfs(i, j);
                count++;
            }
        }
    }
    return count;
}

const ni = (grid) => {
    if (!grid || grid.length === 0 || grid[0].length === 0) return 0;
    let m = grid.length, n = grid[0].length;

    class UnionFind {
        constructor(grid) {
            this.id = new Array(m * n);
            this.sz = new Array(m * n);
            this.count = 0;
            for (let i = 0; i < m; i++) {
                for (let j = 0; j < n; j++) {
                    if (grid[i][j] === '1') {
                        let val = i * n + j;
                        this.id[val] = val;
                        this.sz[val] = 1;
                        this.count++;
                    }
                }
            }
        }

        union(p, q) {
            let pr = this.find(p), qr = this.find(q);
            if (pr === qr) return;
            if (this.sz[pr] > this.sz[qr]) {
                this.id[qr] = pr;
                this.sz[pr]++;
            } else {
                this.id[pr] = qr;
                this.sz[qr]++;
            }
            this.count--;
        }

        find(p) {
            while (p !== this.id[p]) p = this.id[p];
            return p;
        }
    };
    const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    const uf = new UnionFind(grid);
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === '1') {
                for (let k = 0; k < 4; k++) {
                    let i1 = i + directions[k][0];
                    let j1 = j + directions[k][1];
                    if (i1 > -1 && i1 < m && j1 > -1 && j1 < n && grid[i1][j1] === '1') {
                        uf.union(i*n + j, i1*n + j1);
                    }
                }
            }
        }
    }

    return uf.count;

}




console.log(ni([["1","0","1","1","1"],["1","0","1","0","1"],["1","1","1","0","1"]]))