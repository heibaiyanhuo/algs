/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 */


const checkSubarraySum = (nums, k) => {
    if (!nums || nums.length < 2) return false;
    let currSum = 0;
    let map = new Map();
    map.set(0, -1);
    for (let i = 0; i < nums.length; i++) {
        currSum += nums[i];
        let tmp = (k === 0 ? currSum : currSum % k);
        if (map.has(tmp)) {
            if (i - map.get(tmp) > 1) return true;
        } else {
            map.set(tmp, i);    
        }
    }
    return false;
}