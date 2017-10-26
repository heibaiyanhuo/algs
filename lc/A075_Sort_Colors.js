/**
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */

var sortColors = function(nums) {
    let i = 0, j = 0;
    for (let k = 0; k < nums.length; k++) {
        let temp = nums[k];
        nums[k] = 2;
        if (temp < 2) {
            nums[j] = 1;
            j++;
        }
        if (temp === 0) {
            nums[i] = 0;
            i++;
        }
    }
    return nums;
};

const swap = (nums, i, j) => {
    [nums[i], nums[j]] = [nums[j], nums[i]];
}

console.log(sortColors([0,0,0,0]))