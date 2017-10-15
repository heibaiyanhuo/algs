/**
Given two strings s and t, write a function to determine if t is an anagram of s.
 */

var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    let lf = new Array[128].fill(0);
    Array.from(s).forEach((val, idx) => {
        lf[val.charCodeAt(0)] += 1;
        lf[t.charAt(idx).charCodeAt(0)] -= 1;
    })
    return lf.every(val => val === 0);
};
