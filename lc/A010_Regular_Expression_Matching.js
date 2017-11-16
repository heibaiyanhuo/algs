/**
Implement regular expression matching with support for '.' and '*'.
 */

var isMatch = function(s, p) {
    if (s === null || p === null) return false;
    let sl = s.length, pl = p.length;
    let dp = new Array(sl + 1);
    for (let i = 0; i <= sl; i++) {
        dp[i] = new Array(pl + 1).fill(false);
    }

    dp[0][0] = true;


    for (let j = 1; j < pl; j++) {
        if (p.charAt(j) == '*' && dp[0][j-1]) {
            dp[0][j+1] = true;
        }
    }


    for (let i = 0; i < sl; i++) {
        for (let j = 0; j < pl; j++) {
            if (p.charAt(j) === s.charAt(i) || p.charAt(j) === '.') {
                dp[i + 1][j + 1] = dp[i][j];
            } else if (p.charAt(j) === '*') {
                if (p.charAt(j - 1) === s.charAt(i) || p.charAt(j - 1) === '.') {
                    dp[i + 1][j + 1] = (dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1]);
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                }
            }
        }
    }
    return dp[sl][pl];
};

const isMatch2 = (s, p) => {
    let sl = s.length, pl = p.length;
    let dp = new Array(sl + 1);
    for (let i = 0; i <= sl; i++) {
        dp[i] = new Array(pl + 1).fill(false);
    }
    dp[0][0] = true;
    for (let i = 0; i <= sl; i++) {
        for (let j = 1; j <= pl; j++) {
            if (p.charAt(j - 1) === '*') {
                dp[i][j] = j > 1 && (dp[i][j - 2] || ((i > 0 && s.charAt(i - 1) === p.charAt(j - 2)) || p.charAt(j - 2) === '.') && dp[i - 1][j]);
            } else {
                dp[i][j] = (i > 0 && (s.charAt(i - 1) === p.charAt(j - 1) || p.charAt(j - 1) === '.') && dp[i - 1][j - 1]);
            }
        }
    }
    return dp[sl][pl];
}

// console.log(isMatch('', '.*'))
console.log(isMatch2('aab', 'c*a*b'));