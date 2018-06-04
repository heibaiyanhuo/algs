const uniquePaths = (m, n) => {
    return com(m - 1, m + n - 2);
}

// const com = (x, y) => {
//     if (x === 0 || x === y) return 1;
//     if (x === 1 || x === y - 1) return y;
//     return com(x, y - 1) + com(x - 1, y - 1);
// }


const com = (x, y) => {
    let rows = new Array(100).fill(0);
    rows[0] = 1;

    for (let i = 0; i <= y; i++) {
        for (let j = i; j > 0; j--) {
            rows[j] += rows[j - 1];
        }
    }
    return rows[x];
}

// console.log(uniquePaths(3, 7))
console.log(com(3, 10))
