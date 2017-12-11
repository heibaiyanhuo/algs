/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */

const findMaxLength = (nums) => {
    let diff = 0;
    let map = new Map();
    let res = 0;
    for (let i = 0; i < nums.length; i++) {
        diff += (nums[i] === 0 ? 1 : -1);
        if (diff === 0) res = i + 1;
        else if (map.has(diff)) res = Math.max(res, i - map.get(diff));
        if (!map.has(diff)) map.set(diff, i);
    }
    return res;
}

console.log(findMaxLength([0,0,1,0,0,0,1,1]))