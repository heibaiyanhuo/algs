
var permuteUnique = function(nums) {
    let result = [], one = [];
    // let usedMap = new Map();
    let usedSet = new Set();
    nums.sort();
    backtrack(result, one, nums, usedSet);
    return result;
};


const backtrack = (result, one, nums, usedSet) => {
    if (one.length === nums.length) {
        result.push(one.slice());
        return;
    }

    for (let i = 0; i < nums.length; i++) {
        if (usedSet.has(i) || (i > 0 && nums[i] === nums[i-1] && !usedSet.has(i - 1))) continue;
        usedSet.add(i);
        one.push(nums[i]);
        backtrack(result, one, nums, usedSet);
        one.pop(); 
        usedSet.delete(i);
    }
    return;
}

console.log(permuteUnique([3, 3, 0, 3]));