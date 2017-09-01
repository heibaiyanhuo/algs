/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 */

var isPalindrome = function(s) {
    let low = 0, high = s.length - 1;
    while (low < high) {
        if (!isAlphanumeric(s.charAt(low))) {
            low++;
            continue;
        }
        if (!isAlphanumeric(s.charAt(high))) {
            high--;
            continue;
        }
        if (s.charAt(low).toLowerCase() !== s.charAt(high).toLowerCase()) return false;
        low++;
        high--;
    }
    return true;
};

const isAlphanumeric = (c) => (/[a-zA-Z0-9]/.test(c));

console.log('====================================');
console.log(isPalindrome('A man, a plan, a canal: Panama'));
console.log('====================================');