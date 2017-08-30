/**
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).
 */

var searchRange = function(nums, target) {
    let res = [];
    res[0] = findTheFirst(nums, target);
    res[1] = findTheLast(nums, target);
    return res;
};

const findTheFirst = (nums, target) => {
    let index = -1, low = 0, high = nums.length - 1;
    while (low <= high) {
        let mid = parseInt((low + high) / 2);
        if (nums[mid] < target) {
            low = mid + 1
        } else {
            high = mid - 1;
        }
        if (nums[mid] === target) index = mid;
    }
    return index;
}

const findTheLast = (nums, target) => {
    let index = -1, low = 0, high = nums.length - 1;
    while (low <= high) {
        let mid = parseInt((low + high) / 2);
        if (nums[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
        if (nums[mid] === target) index = mid;
    }
    return index;
}