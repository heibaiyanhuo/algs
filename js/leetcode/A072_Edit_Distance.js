/**
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

 */

var minDistance = function(word1, word2) {
    let l1 = word1.length;
    let l2 = word2.length;
    let dp = new Array(l1 + 1);
    for (let i = 0; i < l1; i++) {
        dp[i] = new Array(l2 + 1);
    }

    dp[0][0] = 0;
    for (let i = 1; i <= l2; i++) dp[0][i] = i;
    for (let i = 1; i <= l1; i++) dp[i][0] = i;

    for (let i = 1; i <= l1; i++) {
        for (let j = 1; j <= l2; j++) {
            if (word1.charAt(i - 1) === word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
            }
        }
    }

    return dp[l1][l2];
};