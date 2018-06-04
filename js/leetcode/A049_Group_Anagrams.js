/**
Given an array of strings, group anagrams together.
 */

var groupAnagrams = function(strs) {
    let r = {}, result = [];
    for (let str of strs) {
        let p = toPattern(str);
        if (r[p]) {
            r[p].push(str);
        } else {
            r[p] = [str];
        }
    }
    for (let key in r) {
        result.push(r[key]);
    }
    return result;
};

const toPattern = (str) => {
    str.toLowerCase();
    let p = new Array(26).fill(0);
    for (let c of str) {
        let idx = c.charCodeAt(0) - 97;
        p[idx] = p[idx] ? p[idx] + 1 : 1;
    }
    return p.toString();
}


console.log(groupAnagrams(["tea","and","ace","ad","eat","dans"]))