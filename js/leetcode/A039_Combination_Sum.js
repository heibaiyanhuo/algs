/**
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.
 */

var combinationSum = function(candidates, target) {
    results = [];
    onesolution = [];
    candidates.sort();
    backtrack(results, onesolution, candidates, target, 0);
    return results;
};

const backtrack = (results, onesolution, nums, remains, start) => {
    if (remains < 0) return;
    else if (remains === 0) {
        results.push(onesolution.slice());
    }
    else {
        for (let i = start; i < nums.length; i++) {
            onesolution.push(nums[i]);
            backtrack(results, onesolution, nums, remains - nums[i], i + 1);
            onesolution.pop();
        }
    }
}

console.log(combinationSum([10,1,2,7,6,1,5], 8))