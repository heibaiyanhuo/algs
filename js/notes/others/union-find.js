class UF {
    constructor(N) {
        this._count = N;
        this.id = new Array(N);
        this.sz = new Array(N).fill(1);
        for (let i = 0; i < N; i++) {
            this.id[i] = i;
        }
    }

    union(p, q) {
        let pr = this.find(p);
        let qr = this.find(q);

        if (pr === qr) return;
        if (this.sz[pr] > this.sz[qr]) {
            this.id[qr] = pr;
            this.sz[pr]++;
        } else {
            this.id[pr] = qr;
            this.sz[qr]++;
        }
        this._count--;
    }

    find(p) {
        while (p !== this.id[p]){
            this.id[p] = this.id[this.id[p]]; // Path Compression
            p = this.id[p];
        } 
        return p;
    }

    connected(p, q) {
        return this.find(p) === this.find(q);
    }

    count() {
        return this._count;
    }
}

let uf = new UF(10);


console.log(uf.connected(3, 9))
console.log(uf.count())