/**
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 */

const fms = (nums) => {
    let sp = 0, ep = 0, res = Number.MAX_SAFE_INTEGER;
    let sum = 0;

    while (ep < nums.length) {
        sum += nums[ep++];
        while (sum >= s) {
            res = Math.min(res, ep - sp);
            sum -= nums[sp++];
        }
    }
    return res === Number.MAX_SAFE_INTEGER ? 0 : res;
}