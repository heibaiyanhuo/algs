/**
 * 
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */

var containsNearbyDuplicate = function(nums, k) {
    let s = new Set();
    for (let i = 0; i < nums.length; i++) {
        if (s.has(nums[i])) return true;
        else {
            s.add(nums[i]);
            if (s.size > k) s.delete(nums[i - k]);
        }
    }
    return false;
};