/**
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */

var threeSum = function(nums) {
    let res = [];
    nums.sort((a, b) => (a - b));
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > 0) return res;
        if (i > 0 && nums[i] === nums[i-1]) continue;
        let low = i + 1;
        let high = nums.length - 1;
        let temp = 'a';
        while (low < high) {
            if ((nums[low] + nums[high]) === -nums[i]) {
                if (nums[low] != temp) {
                    res.push([nums[i], nums[low], nums[high]]);
                }
                temp = nums[low];
                low++;
                high--;
            } else if ((nums[low] + nums[high]) < -nums[i]) {
                low++;
            } else {
                high--;
            }
        }
    }
    return res;
};

console.log(threeSum([3,0,-2,-1,1,2]));