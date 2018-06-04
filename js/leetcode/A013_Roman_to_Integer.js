/**
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */

var romanToInt = function(s) {
    let res = 0;
    for (let i = s.length - 1; i >= 0; i--) {
        // console.log(s.charAt(4));
        let a = transfer(s.charAt(i));
        
        if (i === 0) {
            res += a;
            return res;
        }
        let b = transfer(s.charAt(i - 1));
        if (a > b) {
            res += (a - b);
            i--;
        } else {
            res += a;
        }
    }
    return res;
};

var transfer = (c) => {
    // console.log(c);
    switch (c) {
        case 'I': return 1;
        case 'V': return 5;
        case 'X': return 10;
        case 'L': return 50;
        case 'C': return 100;
        case 'D': return 500;
        case 'M': return 1000;
        default: return 0;
    }
}

console.log(romanToInt('DCXXI'));
// console.log(transfer('I'));