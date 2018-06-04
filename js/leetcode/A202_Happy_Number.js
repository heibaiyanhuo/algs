/**
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 */

var isHappy = function(n) {
    let m = new Set();
    let sum = digitsSquareSum(n);
    while (true) {
        if (sum === 1) return true;
        if (m.has(sum)) return false;
        else {
            m.add(sum);
        }
        sum = digitsSquareSum(sum);
    }
};
const digitsSquareSum = (n) => {
    let res = 0;
    while (n > 0) {
        let t = n % 10;
        res += t*t;
        n = parseInt((n - t)/10);
    }
    return res;
}
console.log('====================================');
console.log(isHappy(193));
console.log('====================================');