/**
Given two strings s and t, write a function to determine if t is an anagram of s.
 */

var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    let map = new Map();
    const count = (v, b) => {
        let n = b ? 1 : -1;
        if (!map.has(v)) map.set(v, n);
        else map.set(v, map.get(v) + n);
    }
    Array.from(s).forEach((val, index) => {
        count(val, true);
        count(t.charAt(index), false);
    })
    for(let values of map.values()) {
        if (values !== 0) return false;
    }
    return true;
};
