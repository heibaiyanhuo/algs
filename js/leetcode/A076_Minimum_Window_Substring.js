/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O * (n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 */

const minWindow = (s, t) => {
    let tmap = new Array(128).fill(0);
    let begin = 0, end = 0, minLength = -1, counter = t.length;
    let head;
    for (let c of t) {
        tmap[c.charCodeAt(0)]++;
    }
    while (end < s.length) {
        if (tmap[s.charAt(end++).charCodeAt(0)]-- > 0) counter--;
        while (counter === 0) {
            if (minLength === -1 || end - begin < minLength) {
                minLength = end - begin;
                head = begin;
            }
            if (tmap[s.charAt(begin++).charCodeAt(0)]++ === 0) counter++;
        }
    }
    return minLength === -1 ? '' : s.substr(head, minLength);
}

console.log(minWindow('ab', 'b'))