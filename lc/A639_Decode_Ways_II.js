

const numDecodings = (s) => {
    const MOD = 10 ** 9 + 7;
    let dp = new Array(3);
    dp[0] = 1, dp[1] = 0,  dp[2] = 0;
    for (let c of s) {
        let tmp = dp[0];
        if (c === '*') {
            dp[0] = (9 * dp[0] + 9 * dp[1] + 6 * dp[2]) % MOD;
            dp[1] = tmp;
            dp[2] = tmp;
        } else {
            let n = ~~c;
            dp[0] = ((n > 0 ? dp[0] : 0) + dp[1] + (n < 7 ? dp[2] : 0)) % MOD;
            dp[1] = n === 1 ? tmp : 0;
            dp[2] = n === 2 ? tmp : 0;
        }
    }

    return dp[0];
}