/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be * segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does * * not contain duplicate words.
 */

const wordBreak = (s, wordDict) => {
    const length = s.length;
    let dp = new Array(length + 1).fill(false);
    dp[0] = true;
    for (let i = 1; i <= length; i++) {
        for (let str of wordDict) {
            if (str.length <= i && dp[i - str.length] && str === s.substring(i - str.length, i)) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[length];
}