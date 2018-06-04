/**
 * 
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 */

var plusOne = function(digits) {
    let i = digits.length - 1;
    if (digits[i] == 9) {
        digits[i] = 0;
        carry(digits, i);
    } else {
        digits[i] += 1;
    }
    return digits;
};

var carry = function(digits, n) {
    if (n == 0) {
        digits.unshift(1);
    } else {
        if (digits[n - 1] == 9) {
            digits[n - 1] = 0;
            carry(digits, n - 1);
        } else {
            digits[n - 1] += 1;
        }
    }
}

console.log(plusOne([9,9,9,9]));
// console.log(test([1,2,3]));