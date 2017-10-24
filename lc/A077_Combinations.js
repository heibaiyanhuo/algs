

const combine = (n, k) => {
    let one = [];
    let all = [];
    backtrack(all, one, k, n);
    return all;
}

const backtrack = (all, one, k, n) => {
    if (one.length === k) {
        all.push(one.slice());
        return;
    }

    for (let i = 1; i < n+1; i++) {
        if (one.length === 0 || one[one.length - 1] < i) {
            one.push(i);
            backtrack(all, one, k, n);
            one.pop()
        }
    }
}

console.log(combine(4, 2));