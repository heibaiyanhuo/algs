/**
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
 */

var hammingDistance = function(x, y) {
    let tmp = x^y, count = 0;
    while (tmp > 0) {
        if (tmp % 2 === 1) {
            count++;
        }
        tmp >>= 1;
    }
    return count;
};