
const binarySearch = (nums, target) => {
    let lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        let mid = Math.floor((lo+hi)/2);
        if (nums[mid] === target) return mid;
        if (nums[mid] > target) hi = mid - 1;
        else lo = mid + 1;
    }
    return lo;
}


test(s);
// console.log(test(s))

// console.log(binarySearch([1, 10, 23, 23], 25))