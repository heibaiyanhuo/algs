/**
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */

const r1 = (nums, k) => {
    let aux = nums.slice();
    for (let i = 0; i < nums.length; i++) {
        nums[i] = aux[(i + (nums.length - k % nums.length)) % nums.length];
    }
}

const r2 = (nums, k) => {
    const reverse = (s, e) => {
        while (s < e) {
            [nums[s], nums[e]] = [nums[e], nums[s]];
            s++;
            e--;
        }
    }
    k %= nums.length;
    reverse(0, nums.length - 1);
    reverse(0, k);
    reverse(k, nums.length - 1);
}