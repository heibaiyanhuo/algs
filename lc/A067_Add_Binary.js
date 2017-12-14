/**
 * Given two binary strings, return their sum (also a binary string).
 */

var addBinary = function(a, b) {
    if (!a) return b;
    if (!b) return a;
    let ret = '';
    let i = a.length - 1, j = b.length - 1;
    let carry = 0;
    while (i > -1 || j > -1 || carry > 0) {
        let acurr = i > -1 ? ~~a.charAt(i--) : 0;
        let bcurr = j > -1 ? ~~b.charAt(j--) : 0;
        let res_curr = acurr ^ bcurr ^ carry;
        carry = acurr + bcurr + carry > 1 ? 1 : 0
        ret += res_curr;
    }
    return ret;
};

console.log('====================================');
console.log(addBinary('1010', '1011'));
console.log('====================================');