/**
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 */

const addOperators = (num, target) => {
    if (!num || num.length === 0) return [];
    let ret = [];
    const dfs = (path, start, eval, mutiVal) => {
        if (start === num.length) {
            if (eval === target) {
                ret.push(path);
            }
            return;
        }
        for (let i = start; i < num.length; i++) {
            if (i !== start && num.charAt(start) === '0') break;
            let curr = ~~num.substring(start, i + 1);
            if (start === 0) {
                dfs('' + curr, i + 1, curr, curr);
            } else {
                dfs(path + '+' + curr, i + 1, eval + curr, curr);
                dfs(path + '-' + curr, i + 1, eval - curr, -curr);
                dfs(path + '*' + curr, i + 1, eval - mutiVal + mutiVal * curr, mutiVal * curr);
            }
        }
    }
    dfs('', 0, 0, 0);
    return ret;
}

console.log(addOperators('105', 5));