/**
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */


const longestValidParentheses = (s) => {
    let sl = s.length, dp = new Array(sl).fill(0);
    let ml = 0;
    dp[0] = 0;
    for (let i = 1; i < sl; i++) {
        if (s.charAt(i) === ')') {
            if (s.charAt(i - 1) === '(') {
                dp[i] = (dp[i - 2] || 0) + 2;
            } else if (s.charAt(i - dp[i - 1] - 1) === '(') {
                dp[i] = dp[i - 1] + (dp[i - dp[i - 1] - 2] || 0) + 2;
            }
            ml = Math.max(ml, dp[i]);
        }
    }
    return ml;
}

const lvp2 = (s) => {
    let ps = [-1];
    let ml = 0;
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) === '(') {
            ps.push(i);
        } else {
            ps.pop();
            let tmp = ps.length;
            if (tmp === 0) {
                ps.push(i);
            } else {
                ml = Math.max(ml, i - ps[tmp - 1]);
            }
        }
    }
    return ml;
}

// console.log(longestValidParentheses('())'));
console.log(lvp2(')()()())'))
