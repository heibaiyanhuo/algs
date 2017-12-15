/**
 * 
 * 
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.
 */

var searchInsert = function(nums, target) {
    let lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        let mid = Math.floor((lo + hi)/2);
        if (nums[mid] === target) return mid;
        if (nums[mid] > target) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
};

console.log(searchInsert([1,2,3], 3));