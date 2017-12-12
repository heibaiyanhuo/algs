/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 */

const subarraySum = function(nums, k) {
    if (nums.length === 0) return 0;
    let sum = 0;
    const map = new Map();
    let count = 0;
    map.set(0, 1);
    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (map.has(sum - k)) count += map.get(sum - k);
        map.set(sum, (map.get(sum) || 0) + 1);
    }
    return count;
};