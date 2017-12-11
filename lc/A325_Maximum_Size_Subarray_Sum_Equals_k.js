/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 */

const maxSubArrayLen = (nums, k) => {
    let map = new Map();
    let sum = 0;
    let res = 0;
    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum === k) res = i + 1;
        else if (map.has(sum - k)) res = Math.max(res, i - map.get(sum - k));
        if (!map.has(sum)) map.set(sum, i);
    }
    console.log(map)
    return res;
}

console.log(maxSubArrayLen([1, 0, -1], -1))

