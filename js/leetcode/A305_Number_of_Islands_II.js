/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

var numIslands2 = function(m, n, positions) {
    if (m === 0 || n === 0 || positions.length === 0) return [];
    let ret = [];
    let directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    class UnionFind {
        constructor() {
            this.id = new Array(m * n);
            this.sz = new Array(m * n);
            this.count = 0;
        }

        add(i, j) {
            let val = i*n + j;
            this.id[val] = val;
            this.sz[val] = 1;
            this.count++;
            for (let k = 0; k < 4; k++) {
                let x = i + directions[k][0];
                let y = j + directions[k][1];
                let tmp = x * n + y;
                if (x > -1 && x < m && y > -1 && y < n && this.id[tmp] !== undefined) {
                    this.union(val, tmp);
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
            while (this.id[p] !== p) p = this.id[p];
            return p;
        }
    }

    const uf = new UnionFind();
    for (let i = 0; i < positions.length; i++) {
        let i1 = positions[i][0], j1 = positions[i][1];
        uf.add(i1, j1);
        ret.push(uf.count);
    }

    return ret;
};

console.log(numIslands2(3, 3, [[0,0], [0,1], [1,2], [2,1]]));