/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 */

const multiply = (num1, num2) => {
    let m = num1.length, n = num2.length;
    let res = new Array(m + n).fill(0);
    for (let i = m - 1; i > -1; i--) {
        for (let j = n - 1; j > -1; j--) {
            let currMul = ~~num1.charAt(i) * ~~num2.charAt(j);
            let pos1 = i + j, pos2 = i + j + 1;
            let sum = currMul + res[pos2];
            res[pos1] += Math.floor(sum/10);
            res[pos2] = sum % 10;
        }
    }
    while (res[0] === 0) res.shift();
    return res.length === 0 ? '0' : res.join('');
}

console.log(multiply('23232', '11'));