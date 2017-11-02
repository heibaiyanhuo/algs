

var lengthOfLongestSubstring = (s) => {
    let res = 0, from = 0;
    let m = new Map();
    for (let i = 0; i < s.length; i++) {
        if (m.has(s.charAt(i))) from = Math.max(from, m.get(s.charAt(i) ) + 1);
        // if (m.has(s.charAt(i))) from = m.get(s.charAt(i) ) + 1;
        m.set(s.charAt(i), i);
        res = Math.max(res, i - from + 1);
    }
    return res;
}

console.log(lengthOfLongestSubstring('abcbbbefg'));