/**
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may
    not use the same element twice.
 */

var twoSum = function (nums, target) {
    var a = new Map();
    for(var i = 0; i < nums.length; i++) {
        if (a.has(nums[i])) {
            return [a.get(nums[i]), i];
        } else {
            a.set(target - nums[i], i);
        }
    }
}

console.log(twoSum([3, 2, 4], 6));