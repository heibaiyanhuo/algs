/**
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 */

var findShortestSubArray = function(nums) {
    let degree = 0, minmum = nums.length;
    let m = new Map();
    nums.forEach((val, idx) => {
        if (m.has(val)) {
            let temp = m.get(val);
            temp[1] = idx;
            temp[2] += 1;
            m.set(val, temp);
        } else {
            m.set(val, [idx, idx, 1]);
        }
    });

    for (let val of m.values()) {
        if (val[2] > degree) {
            degree = val[2];
            minmum = val[1] - val[0] + 1
        } else if (val[2] === degree) {
            let temp = val[1] - val[0] + 1;
            if (minmum > temp) minmum = temp;
        }
    }

    return minmum;
};

console.log(findShortestSubArray([1,2,2,3,1]))