/**
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.
 */

const findTargetSumWays = (nums, S) => {
    if (nums.length === 0) return 0;
    let count = 0;
    const dfs = (res, i) => {
        if (i === nums.length) {
            if (res === S) count++;
            return;
        }
        dfs(res + nums[i], i + 1);
        dfs(res - nums[i], i + 1);
    }
    dfs(0, 0);
    return count;
}

const fts = (nums, S) => {
    if (nums.length === 0) return 0;
    let sum = 0;
    for (let num of nums) {
        sum += num;
    }
    let target = sum + S;
    if (target & 1) return 0;
    target >>= 1;
    
    let dp = new Array(target + 1).fill(0);
    dp[0] = 1;
    for (let num of nums) {
        for (let i = target; i >= num; i--) {
            dp[i] += dp[i - num];
        }
    }

    return dp[target];
}

console.log(findTargetSumWays([1, 1, 1, 1, 1], 1));