/**
 * 
 * 
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 */

var maxSubArray = function(nums) {
    let a = nums[0], b = nums[0];
    for (let i = 1; i < nums.length; i++) {
        b = Math.max(nums[i], b + nums[i]);
        a = Math.max(a, b);
    }
    return a;
};

console.log(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]));