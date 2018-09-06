
const completePack = (limit, costs, worths) => {
    const N = costs.length;
    let dp = new Array(limit + 1).fill(0);

    for (let i = 1; i <= N; i++) {
        for (let l = costs[i - 1]; l <= limit; l++) {
            dp[l] = Math.max(dp[l], dp[l - costs[i - 1]] + worths[i - 1]);
        }
    }
    return dp[limit];
}

export { completePack };
