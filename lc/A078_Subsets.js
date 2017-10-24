/**
Given a set of distinct integers, nums, return all possible subsets (the power set).
 */

var subsets = function(nums) {
    let subsets = [];
    nums.sort();
    for (let i = 0; i < nums.length + 1; i++) {
        bt(subsets, [], nums, i);
    }
    return subsets;
};


const bt = (all, one, nums, k) => {
    if (one.length === k) {
        all.push(one.slice());
        return;
    }

    for (let j = 0; j < nums.length; j++) {
        if (one.length === 0 || nums[j] > one[one.length - 1]) {
            one.push(nums[j]);
            bt(all, one, nums, k);
            one.pop();
        }
    }
}

console.log(subsets([1, 2, 3, 4]))