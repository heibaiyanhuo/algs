

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

const lls2 = (s) => {
    let map = new Array(128).fill(0);
    let begin = 0, end = 0, counter = 0, maxLength = 0;
    
    while (end < s.length) {
        if (map[s.charAt(end++).charCodeAt(0)]++ > 0) counter++;
        while (counter > 0) {
            if (map[s.charAt(begin++).charCodeAt(0)]-- > 1) counter--;
        }
        maxLength = Math.max(maxLength, end - begin);
    }
    
    return maxLength;
}

console.log(lengthOfLongestSubstring('abba'));