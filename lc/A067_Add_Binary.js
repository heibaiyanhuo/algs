/**
 * Given two binary strings, return their sum (also a binary string).
 */

var addBinary = function(a, b) {
    if (a.length > b.length) b = '0'.repeat(a.length - b.length) + b;
    else a = '0'.repeat(b.length - a.length) + a;
    let arrayA = Array.from(a), arrayB = Array.from(b), length = arrayA.length;
    let carry = '0';
    for (let i = length - 1; i > -1; i--) {
        let temp = arrayA[i] + arrayB[i] + carry;
        if (i === 0) {
            switch (temp) {
                case '110':
                case '101':
                case '011':
                    arrayA[0] = '0';
                    arrayA.unshift('1');
                    return arrayA.join('');
                case '111':
                    arrayA[0] = '1';
                    arrayA.unshift('1');
                    return arrayA.join('');
                default: break;
            }
        }
        switch (temp) {
            case '000':
            case '100':
                break;
            case '010':
                arrayA[i] = '1';
                break;
            case '001':
                arrayA[i] = '1';
                carry = '0';
                break;
            case '110':
            case '011':
            case '101':
                arrayA[i] = '0';
                carry = '1';
                break;
            case '111':
                arrayA[i] = '1';
                carry = '1'
                break;
            default:
                throw Error;
                break;
        }
        
    }
    return arrayA.join('');
};

console.log('====================================');
console.log(addBinary('1010', '1011'));
console.log('====================================');