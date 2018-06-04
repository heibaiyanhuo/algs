/**
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 */

var fourSum = function(nums, target) {
    let length = nums.length;
    let res = [];
    if (length < 4) return res;
    nums.sort((a, b) => (a - b));
    if (4 * nums[length - 1] < target) return res;
    for (let i = 0; i < length - 3; i++) {
        if (4 * nums[i] > target) return res;
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        for (let j = i + 1; j < length - 2; j++) {
            if (j > (i + 1) && nums[j] === nums[j - 1]) continue;
            let low = j + 1;
            let high = length - 1;
            while (low < high) {
                let sum = nums[i] + nums[j] + nums[low] + nums[high];
                if (sum === target) {
                    res.push([nums[i], nums[j], nums[low], nums[high]]);
                    while (low < high && nums[low + 1] === nums[low]) low++;
                    while (low < high && nums[high - 1] === nums[high]) high--;
                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
    }
    return res;
};

console.log(fourSum([-3, -2, -1, 0, 0, 1, 2, 3], 0));
