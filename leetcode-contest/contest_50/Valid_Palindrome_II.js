/**
 * 
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome. 
 */


var validPalindrome = function(s) {
    if (s.isPalindrome) return true;
    let lo = 0, hi = s.length - 1;
    while (lo < hi) {
        if (s.charAt(lo) !== s.charAt(hi)) {
            let s1 = s.substring(lo + 1, hi + 1);
            let s2 = s.substring(lo, hi);
            return isPalindrome(s1) || isPalindrome(s2)
        }
        lo++;
        hi--;
    }
    return true;
    
};

const isPalindrome = (s) => {
    let lo = 0, hi = s.length - 1;

    while (lo < hi) {
        if (s.charAt(lo) !== s.charAt(hi)) {
            return false;
        }
        lo++;
        hi--;
    }
    return true;
}

console.log(validPalindrome('acckkba'))