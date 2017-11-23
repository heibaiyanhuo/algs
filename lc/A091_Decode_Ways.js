

const numDecodings = (s) => {
    if (s.length === 0 || s.charAt(0) === '0') return 0;
    let dp = new Array(s.length);
    dp[0] = 1;
    for (let i = 1; i < s.length; i++) {
        if (s.charAt(i) === '0') {
            if (s.charAt(i - 1) === '1' || s.charAt(i - 1) === '2') dp[i] = i > 1 ? dp[i - 2] : 1;
            else return 0;
        } else {
            let n = ~~s.substring(i - 1, i + 1);
            if (n < 10 || n > 26) dp[i] = dp[i - 1];
            else dp[i] = dp[i - 1] + (i > 1 ? dp[i - 2] : 1);
        }
    }
    return dp[s.length - 1];
}