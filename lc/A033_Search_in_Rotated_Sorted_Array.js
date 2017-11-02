/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */

var search = function(nums, target) {
    let low = 0, high = nums.length;

    while (low < high) {
        let mid = Math.floor((low + high) / 2);
        let num = ((target < nums[0]) === (nums[mid] < nums[0])) ? nums[mid] : (target < nums[0] ? Number.NEGATIVE_INFINITY : Number.POSITIVE_INFINITY);


        if (num > target) {
            high = mid;
        } else if (num < target) {
            low = mid + 1;
        } else {
            return mid;
        }
    }

    return -1;
};

console.log(search([1], 2));