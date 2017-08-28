/**
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.
 */
var lengthOfLastWord = function(s) {
    let p = s.length - 1;
    if (p === -1) return 0;
    let length = 0;
    while (p > -1 && s.charAt(p--) === ' ');
    while (p > -1 && s.charAt(p--) !== ' ') length++;
    return length;
};

lengthOfLastWord('w   ');