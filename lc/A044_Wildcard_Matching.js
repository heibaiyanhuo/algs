/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 */


const isMatch = (s, p) => {
    let sl = s.length, pl = p.length;
    let dp = new Array(sl + 1);
    for (let i = 0; i <= sl; i++) {
        dp[i] = new Array(pl + 1).fill(false);
    }
    dp[0][0] = true;


    for (let i = 0; i <= sl; i++) {
        for (let j = 1; j <= pl; j++) {
            if (p.charAt(j - 1) === '*') {
                dp[i][j] = dp[i][j - 1] || (i > 0 && dp[i - 1][j]);
            } else {
                dp[i][j] = i > 0 && (p.charAt(j - 1) === '?' || p.charAt(j - 1) === s.charAt(i - 1)) && dp[i - 1][j - 1];
            }
        }
    }

    return dp[sl][pl];
}

/**
const isMatch2 = (s, p) => {
    let sp = 0, pp = 0, match = 0, starIdx = -1;
    while (sp < s.length) {
        if (pp < p.length && (p.charAt(pp) === '?' || (p.charAt(pp) !== '*' && p.charAt(pp) === s.charAt(sp)))) {
            sp++;
            pp++;
        } else if (pp < p.length && p.charAt(pp) === '*') {
            starIdx = pp;
            match = sp;
            pp++;
        } else if (starIdx !== -1) {
            pp = starIdx + 1;
            match++;
            s = match;
        } else {
            return false;
        }
    }

    while (pp < p.length && p.charAt(pp) === '*') {
        pp++;
    }

    return pp === p.length;
}

*/

console.log(isMatch('acaxayb', 'a*ayb'))