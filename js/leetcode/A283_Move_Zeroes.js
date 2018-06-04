/**
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */

var moveZeroes = function(nums) {
    let pointer = 0, length = nums.length;
    for (let num of nums) {
        if (num !== 0) {
            num[pointer++] = num[i];
        }
    }

    while (pointer < num.length) {
        num[pointer++] = 0;
    }


    return nums;
};

console.log(moveZeroes([0, 1, 0, 3, 12]))