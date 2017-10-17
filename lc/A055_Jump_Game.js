/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
 */

var canJump = function(nums) {
    let furthest = 0;
    for (let i = 0; i < nums.length; i++) {
        if (i > furthest) return false;
        furthest = Math.max(furthest, i + nums[i]);
    }
    return true;
};



console.log(canJump([2,3,1,1,4]))