/**
 * 
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */


var longestPalindromincSubstring = (s) => {
    let low = 0, maxlength = 0;
    const extendPalindrome = (j, k) => {
        while (j >= 0 && k < s.length && s.charAt(j) === s.charAt(k)) {
            j--;
            k++;
        }
        if (maxlength < k - j - 1) {
            low = j + 1;
            maxlength = k - j - 1;
        }
    }
    for (let i = 0; i < s.length - (1 + maxlength)/2; i++) {
        extendPalindrome(i, i);
        extendPalindrome(i, i + 1);
    }
    return s.substring(low, low + maxlength);
}

console.log(longestPalindromincSubstring('abbad'));