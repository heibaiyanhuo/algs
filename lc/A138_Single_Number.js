/**
 * 
Given an array of integers, every element appears twice except for one. Find that single one.
 */


var singleNumber = function(nums) {
    return nums.reduce((pre, cur) => pre^cur, 0);
};

console.log('====================================');
console.log(singleNumber([2,2,1]));
console.log('====================================');