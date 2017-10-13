/**
Given a collection of distinct numbers, return all possible permutations.
 */

var permute = function(nums) {
    let result = [];
    let onep = [];
    backtrack(result, onep, nums);
    return result;
};

const backtrack = (result, onep, nums) => {
    if (nums.length === onep.length) {
        result.push(onep.slice());
        return;
    }
    for (let i = 0; i < nums.length; i++) {
        if (!onep.includes(nums[i])) {
            onep.push(nums[i]);
            backtrack(result, onep, nums);
            onep.pop();
        }
    }
}

console.log(permute([1, 2, 5]))