/**
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 */

var canPartitionKSubsets = function(nums, k) {
    if (k === 1) return true;
    let arraySum = nums.reduce((sum, cur) => sum + cur, 0);
    if (arraySum < k || (arraySum%k !== 0)) return false;
    let target = arraySum/k;
    let visited = new Array(nums.length).fill(false);
    nums.sort((a, b) => b - a);
    return backtrack(nums, 0, 0, target, k, visited);
}

const backtrack = (nums, tempSum, start, target, k, visited) => {
    if (k === 0) return true;
    if (tempSum === target) {
        return backtrack(nums, 0, 0, target, k - 1, visited);
    }

    for (let i = start; i < nums.length; i++) {
        if (!visited[i]) {
            if (tempSum + nums[i] <= target) {
                console.log(tempSum + '.....' + nums[i])
                visited[i] = true;
                if (backtrack(nums, tempSum + nums[i], i + 1, target, k, visited)) return true;
                visited[i] = false;
            }
        }
    }
    return false;
}

console.log(canPartitionKSubsets([2,2,2,2,3,4,5],4))