/**
 * 

Write a function to find the longest common prefix string amongst an array of strings. 
 */

var longestCommonPrefix = function(strs) {
    let length = strs.length;
    if (length === 0) return '';
    let res = '';
    for (let i = 0; i < strs[0].length; i++) {
        for (let j = 1; j < length; j++) {
            if (strs[j].length < res.length || strs[j].charAt(i) !== strs[0].charAt(i)) return res;
        }
        res += strs[0].charAt(i);
    }
    
    return res;
};

console.log('====================================');
console.log(longestCommonPrefix(['ab', 'abc']));
console.log('====================================');