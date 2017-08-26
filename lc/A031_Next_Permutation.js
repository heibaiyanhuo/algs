/**
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.
 */

var nextPermutation = function(nums) {
    let length = nums.length;
    if (length === 2) {
        let temp = nums[0];
        nums[0] = nums[1];
        nums[1] = temp;
    } else if (length > 2) {
        let as = 0;
        for (let j = length - 2; j >= 0; j--) {
            if (j === 0 && (nums[0] >= nums[1])) {
                let low = 0, high = length - 1;
                while (low < high) {
                    let temp = nums[low];
                    nums[low] = nums[high];
                    nums[high] = temp;
                    low++;
                    high--;
                }
            } else if (nums[j] >= nums[j + 1]) {
                as++;
                continue;
            } else {
                let low = j + 1;
                let high = length - 1;
                while (low < high) {
                    let temp = nums[low];
                    nums[low] = nums[high];
                    nums[high] = temp;
                    low++;
                    high--;
                }
                for (let k = 0; k < as + 1; k++) {
                    if (nums[j] < nums[j + k + 1]) {
                        let temp = nums[j];
                        nums[j] = nums[j + k +1]
                        nums[j + k + 1] = temp;
                        break;
                    }
                }
                j = -1;
            }
        }
    }
    
    console.log(nums);
};
nextPermutation([1,3,2]);