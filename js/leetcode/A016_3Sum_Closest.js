/**
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */

var threeSumClosest = function(nums, target) {
    if (nums.length <= 3) {
        let r = 0;
        nums.forEach((v) => {
            r += v;
        })
        return r;
    }
    nums.sort((a, b) => (a - b));
    let res = nums[0] + nums[1] + nums[2];
    for (let i = 0; i < nums.length; i++) {
        let low = i + 1;
        let high = nums.length - 1;

        while (low < high) {
            let sum = nums[i] + nums[low] + nums[high];
            if (sum === target) return target;
            if (Math.abs(sum - target) < Math.abs(res - target)) {
                res = sum;
            }
            sum < target? low++ : high--;
        }
    }

    return res;
};

console.log(threeSumClosest([1,2,3,2], 4));