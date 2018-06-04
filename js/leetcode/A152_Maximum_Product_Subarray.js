/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */

const maxProduct = (nums) => {
    const length = nums.length;
    let dp1 = new Array(length), dp2 = new Array(length), mp = null;
    mp = dp1[0] = dp2[0] = nums[0];
    for (let i = 1; i < length; i++) {
        if (nums[i] > 0) {
            dp1[i] = Math.max(dp1[i - 1] * nums[i], nums[i]);
            dp2[i] = Math.min(dp2[i - 1] * nums[i], nums[i]);
        } else if (nums[i] < 0) {
            dp1[i] = Math.max(dp2[i - 1] * nums[i], nums[i]);
            dp2[i] = Math.min(dp1[i - 1] * nums[i], nums[i]);
        } else {
            dp1[i] = dp2[i] = 0;
        }
        mp = Math.max(dp1[i], mp);
    }
    return mp;
}

const mp2 = (nums) => {
    let a = nums[0], b = nums[0], mp = nums[0];
    
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > 0) {
            a = Math.max(a * nums[i], nums[i]);
            b = Math.min(b * nums[i], nums[i]);
        } else if (nums[i] < 0) {
            let tmp = a;
            a = Math.max(b * nums[i], nums[i]);
            b = Math.min(tmp * nums[i], nums[i]);
        } else {
            a = 0;
            b = 0;
        }        
        mp = Math.max(a, mp);
    }
    return mp;
}

// console.log(maxProduct([0, -1, 4, 3, -2, 3,3, 5, -4]))
console.log(mp2([0, -1, 4, 3, -2, 3,3, 5, -4]))