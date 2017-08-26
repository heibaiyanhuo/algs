

var lengthOfLongestSubstring = (s) => {
    let res = 0;
    let letterSet = new Set();
    for (let i = 0; i < s.length - res; i++) {
        let temp = 1;
        letterSet.clear();
        letterSet.add(s.charAt(i));
        for (let p = i + 1; p < s.length; p++) {
            if (letterSet.has(s.charAt(p))) break;
            else {
                letterSet.add(s.charAt(p));
                temp++;
            }
        }
        res = Math.max(res, temp);
    }
    return res;
}

console.log(lengthOfLongestSubstring('abcbbbefg'));