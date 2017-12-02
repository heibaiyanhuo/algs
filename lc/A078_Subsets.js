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


const ss2 = (nums) => {
    if (nums === null) return [];
    let result = [], subArr = [];
    nums.sort((a, b) => a - b);
    const dfs = (length) => {
        if (subArr.length === length) {
            result.push(subArr.slice());
            return;
        }
        
        for (let i = 0; i < nums.length; i++) {
            if (subArr.length === 0 || nums[i] > subArr[subArr.length - 1]) {
                subArr.push(nums[i]);    
                dfs(length);
                subArr.pop();
            }            
        }
    }
    for (let i = 0; i < nums.length; i++) {
        dfs(i);
    }
    if (nums.length > 0) result.push(nums);
    return result;
}

console.log(ss2([1, 2, 3, 10]))