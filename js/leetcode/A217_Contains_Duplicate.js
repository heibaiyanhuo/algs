/**
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */

var containsDuplicate = function(nums) {
    let s = new Set();
    for (let i of nums) {
        if (s.has(i)) return true;
        else s.add(i);
    }
    return false;
};