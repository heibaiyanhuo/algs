/**
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
 */

var removeDuplicates = function(nums) {
    if (nums.length < 3) return nums.length;
    let j = 1, r = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[i] !== nums[i+1]) {
            nums[j++] = nums[i+1];
            r = 0;
        } else {
            if (r === 0) {
                nums[j++] = nums[i+1];
                r = 1;
            }
        }
    }
    console.log(nums)
    return j;
};

const a = (nums) => {
    let i = 0;
    for (let num of nums) {
        if (i < 1 || num > nums[i-1]){
            nums[i++] = num;
        }
    }
    console.log(nums)
    return i;

}

// console.log(removeDuplicates([1,1,2,2,3,3]))
console.log(a([1,2,2,2,2,3]))