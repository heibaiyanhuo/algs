/**
 * Given two arrays, write a function to compute their intersection.

Each element in the result should appear as many times as it shows in both arrays.
 */

const intersect = (nums1, nums2) => {
    let map = new Map();
    let ret = [];
    for (let num of nums1) {
        map.set(num, (map.get(num) || 0) + 1);
    }
    for (let num of nums2) {
        if (map.has(num)) {
            ret.push(num);
            let tmp = map.get(num);
            if (tmp === 1) map.delete(num);
            else map.set(num, tmp - 1);
        }
    }
    return ret;
}

// sorted arr
const is2 = (nums1, nums2) => {
    let p1 = 0, p2 = 0;
    let ret = [];
    while (p1 < nums1.length && p2 < nums2.length) {
        if (nums1[p1] === nums2[p2]) {
            ret.push(nums1[p1]);
            p1++;
            p2++;
        } else if (nums1[p1] < nums2[p2]) {
            p1++;
        } else {
            p2++;
        }
    }
    return ret;
}