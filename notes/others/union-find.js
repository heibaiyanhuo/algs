class UF {
    constructor(N) {
        this.count = N;
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
        this.count--;
    }

    find(p) {
        while (p !== this.id[p]) p = this.id[p];
        return p;
    }

    connected(p, q) {
        return this.find(p) === this.find(q);
    }

    count() {
        return this.count;
    }
}