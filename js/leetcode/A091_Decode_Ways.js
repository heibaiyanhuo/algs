

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

const nd = (s) => {
    if (s.length === 0 || s.charAt(0) === '0') return 0;

    let dp1 = 1, dp2 = 1;

    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) === '0') dp1 = 0;
        if (s.charAt(i - 1) === '1' || (s.charAt(i - 1) === '2' && ~~s.charAt(i) <= 6)) {
            dp1 = dp1 + dp2;
            dp2 = dp1 - dp2;
        } else {
            dp2 = dp1;
        }
    }

    return dp1;
}

const nd2 = (s) => {
    if (s.length === 0 || s.charAt(0) === '0') return 0;
    let dp = new Array(3);
    dp[0] = 1, dp[1] = 0, dp[2] = 0;
    for (let c of s) {
        let n = ~~c, tmp = dp[0];
        dp[0] = (n > 0 ? dp[0] : 0) + dp[1] + (n < 7 ? dp[2] : 0);
        dp[1] = (n === 1 ? tmp: 0);
        dp[2] = (n === 2 ? tmp : 0);
    }
    return dp[0];
}

console.log(nd2('110'))
// console.log(numDecodings('101'));