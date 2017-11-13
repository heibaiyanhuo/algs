/**
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */

var moveZeroes = function(nums) {
    let count = 0, pointer = 0, length = nums.length;
    for (let i = 0; i < length; i++) {
        if (nums[i] === 0) {
            count++;
        } else {
            nums[pointer++] = nums[i];
        }
    }

    while (count > 0) {
        nums[length - count] = 0;
        count--;
    }

    return nums;
};

console.log(moveZeroes([0, 1, 0, 3, 12]))