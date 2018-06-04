/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

var generateParenthesis = function(n) {
    let rs = [];
    bt(rs, '', 0, 0, n);
    return rs;
};


const bt = (rs, s, open, close, max) => {
    if (s.length === max*2) {
        rs.push(s)
        return;
    }

    if (open < max) bt(rs, s + '(', open + 1, close, max);
    if (close < open) {
        bt(rs, s + ')', open, close + 1, max);
    }
}

console.log(generateParenthesis(5))