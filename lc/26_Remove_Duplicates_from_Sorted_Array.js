/**
 * 
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
 */

var removeDuplicates = function(nums) {
    if(nums.length < 2) return nums.length;
    let j = 1;
    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[i] != nums[i+1]) nums[j++] = nums[i+1];
    }
    return j;
};

console.log(removeDuplicates([1,1,2,2,3]));