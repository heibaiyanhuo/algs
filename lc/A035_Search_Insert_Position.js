/**
 * 
 * 
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.
 */

var searchInsert = function(nums, target) {
    let i = 0;
    while (i < nums.length) {
        if (target <= nums[i]) return i;
        else if (target < nums[i++]) return i;
    }
    return i;
};

console.log(searchInsert([1,2,3], 3));