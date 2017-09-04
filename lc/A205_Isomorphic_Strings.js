/**
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 */

var isIsomorphic = function(s, t) {
    if (s.length !== t.length) return false;
    let m1 = new Map(), m2 = new Map();
    for (let i = 0; i < s.length; i++) {
        if (m1.has(s.charAt(i))) {
            if (m1.get(s.charAt(i)) === t.charAt(i)) continue;
            else return false;
        } else {
            if (!m2.has(t.charAt(i))) {
                m1.set(s.charAt(i), t.charAt(i));
                m2.set(t.charAt(i), s.charAt(i));
            } else {
                return false;
            } 
        }
    }
    return true;
};