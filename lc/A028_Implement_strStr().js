/**
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

var strStr = function(haystack, needle) {
    for (let i = 0;; i++) {
        for (let j = 0;; j++) {
            if (j === needle.length) return i;
            if (i + j === haystack.length) return -1;
            if (haystack.charAt(i + j) !== needle.charAt(j)) break;
        }
    }
};

console.log(strStr('abcd', 'bc'));