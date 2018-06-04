/**
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

var removeElement = function(nums, val) {
    let i = 0, j = 0;
    while (i < nums.length) {
        nums[j] = nums[i];
        if (nums[i++] != val) {
            j++;
        }
        console.log(nums);
    }
    console.log(j);
    return j;
};

// console.log();
removeElement([3,2,3,3,2,3], 3);