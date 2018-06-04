/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 */

const longestConsecutive = (nums) => {
    let map = new Map();
    let maxLength = 0;

    for (let n of nums) {
        if (!map.has(n)) {
            let left = map.get(n - 1) || 0;
            let right = map.get(n + 1) || 0;
            let length = left + 1 + right;

            map.set(n, length);
            maxLength = Math.max(maxLength, length);

            map.set(n - left, length);
            map.set(n + right, length);
        }
    }

    return maxLength;
}

const lc2 = (nums) => {
    let set = new Set(nums);
    let maxLength = 0;
    for (let begin of nums) {
        if (!set.has(begin - 1)) {
            let end = begin + 1;
            while (set.has(end)) {
                end++;
            }
            maxLength = Math.max(maxLength, end - begin);
        }
    }
    return maxLength;
}