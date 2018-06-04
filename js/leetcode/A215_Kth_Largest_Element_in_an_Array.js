/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,  * not the kth distinct element.
 */

var findKthLargest = function(nums, k) {
    const partition = (lo, hi) => {
        let i = lo, j = hi + 1;
        let v = nums[lo];
        while (true) {
            while (nums[++i] >= v) if (i === hi) break;
            while (nums[--j] <= v) if (j === lo) break;
            if (i >= j) break;
            [nums[i], nums[j]] = [nums[j], nums[i]];
        }
        [nums[lo], nums[j]] = [nums[j], nums[lo]];
        return j;
    }
    
    let lo = 0, hi = nums.length - 1;
    while (lo < hi) {
        let j = partition(lo, hi);
        if (j === k - 1) return nums[j];
        else if (j < k - 1) lo = j + 1;
        else hi = j - 1;
    }
    return nums[k - 1];
};

console.log(findKthLargest([3, 3, 2, 2, 1, 5], 2))