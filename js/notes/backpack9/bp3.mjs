const multiplePack = (limit, costs, worths, count) => {
    const N = costs.length;
    let dp = new Array(limit + 1).fill(0);

    for (let i = 1; i <= N; i++) {
        while (count[i - 1]-- > 0) {
            for (let l = limit; l >= costs[i - 1]; l--) {
                dp[l] = Math.max(dp[l], dp[l - cost[i - 1]] + worths[i - 1]);
            }
        }
    }

    return dp[limit];
}
