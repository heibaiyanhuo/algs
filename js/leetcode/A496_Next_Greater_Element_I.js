/**
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 */

const nextGreaterElement = (findNums, nums) => {
    let ret = new Array(findNums.length).fill(0);
    let map = new Map();
    for (let i = 0; i < findNums.length; i++) {
        map.set(findNums[i], i);
    }
    let aux = [];
    // 每个元素 只有一次机会入栈和出栈， 时间复杂度O(n)
    for (let i = 0; i < nums.length; i++) {
        while (aux.length !== 0 && nums[i] > aux[aux.length - 1]) {
            let val = aux.pop();
            ret[map.get(val)] = nums[i];
        }
        if (map.has(nums[i])) aux.push(nums[i]);
    }
    return ret;
}