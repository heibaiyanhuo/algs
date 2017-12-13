/**
 * Given two arrays, write a function to compute their intersection.
 */

const intersection = function(nums1, nums2) {
    let res = new Set();
    const set1 = new Set(nums1);
    for (let num of nums2) {
        if (set1.has(num) && !res.has(num)) res.add(num);
    }
    return Array.from(res);
};