/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 */

const removeInvalidParentheses = (s) => {
    let ret = [];
    const dfs = (str, start, last, pair) => {
        let count = 0;
        for (let i = start; i < str.length; i++) {
            if (str.charAt(i) === pair[0]) count++;
            else if (str.charAt(i) === pair[1]) count--;
            if (count >= 0) continue;
            for (let j = last; j <= i; j++) {
                if (str.charAt(j) === pair[1] && (j === last || str.charAt(j - 1) !== pair[1])) {
                    dfs(str.substring(0, j) + str.substring(j + 1, str.length), i, j, pair);
                }
            }
            return;
        }
        let reversed = Array.from(str).reverse().join('');
        console.log(reversed)
        if (pair[0] === '(') {
            dfs(reversed, 0, 0, [')', '(']);
        } else {
            ret.push(reversed);
        }
    }
    dfs(s, 0, 0, ['(', ')']);
    return ret;
}

console.log(removeInvalidParentheses('(()'))