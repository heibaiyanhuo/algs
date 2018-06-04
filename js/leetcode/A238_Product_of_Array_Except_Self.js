/**
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
 */

var productExceptSelf = function(nums) {
    let length = nums.length;
    let ret = new Array(length);
    ret[0] = 1;
    for (let i = 1; i < length; i++) {
        ret[i] = ret[i - 1] * nums[i - 1];
    }
    let right = 1;
    for (let i = length - 1; i >= 0; i--) {
        ret[i] *= right;
        right *= nums[i];
    }
    return ret;
};