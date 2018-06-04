/**
The set [1,2,3,…,n] contains a total of n! unique permutations.
Given n and k, return the kth permutation sequence.
 */

var getPermutation = function(n, k) {
    if (n === 1) return '1';
    let nums = [];
    for (let i = 0; i < n; i++) nums.push(i+1);
    let N = f(n - 1);

    let firstIdx = Math.ceil(k/N) - 1;
    let firstVal = '' + nums[firstIdx]; 
    nums.splice(firstIdx, 1);
    k = k - firstIdx * N;
    return firstVal + helper(N, n - 1, k, nums);
};

const helper = (N, n, k, nums) => {
    if (n === 1) return nums[0];
    N /= n;
    let firstIdx = Math.ceil(k/N) - 1;
    let firstVal = '' + nums[firstIdx];     
    nums.splice(firstIdx, 1);
    k = k - firstIdx * N;
    return firstVal + helper(N, n - 1, k, nums);
}

const f = (n) => {
    let result = 1;
    for (let i = 1; i < n; i++) result *= (i + 1);
    return result;
}


console.log(getPermutation(7, 21))