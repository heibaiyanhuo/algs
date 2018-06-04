/**
 * 
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 */

var validPalindrome = function(s) {
    let lo = 0, hi = s.length - 1;
    const isValid = (i, j) => {
        while (i < j) {
            if (s.charAt(i) !== s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    while (lo < hi) {
        if (s.charAt(lo) === s.charAt(hi)) {
            lo++;
            hi--;
        } else {
            return isValid(lo + 1, hi) || isValid(lo, hi - 1);
        }
    }
    return true;
};