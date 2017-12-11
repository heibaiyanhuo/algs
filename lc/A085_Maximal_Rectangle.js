/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */

const maximalRectangle = (matrix) => {
    if (matrix.length === 0) return 0;
    let m = matrix.length, n = matrix[0].length;
    let maxArea = 0;
    let heights = new Array(n).fill(0);

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] == '0') {
                heights[j] = 0;
                continue;
            }

            heights[j]++;
            let tmp_min = heights[j];
            for (let k = j; k >= 0; k--) {
                if (heights[k] === 0) break;
                tmp_min = Math.min(heights[k], tmp_min);
                maxArea = Math.max((j - k + 1) * tmp_min, maxArea);
            }
        }
    }
    return maxArea;
}

//dp
const mr = (matrix) => {
    if (matrix.length === 0) return 0;
    let m = matrix.length, n = matrix[0].length;
    let maxArea = 0;
    let left = new Array(n).fill(0), right = new Array(n).fill(n), heights = new Array(n).fill(0);
    for (let i = 0; i < m; i++) {
        let cur_left = 0, cur_right = n;
        // console.log(heights)
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === '0') {
                heights[j] = 0;
                left[j] = 0;
                cur_left = j + 1;
            } else {
                heights[j]++;
                left[j] = Math.max(left[j], cur_left);
            }
        }
        for (let j = n - 1; j >= 0; j--) {
            if (matrix[i][j] === '0') {
                right[j] = n;
                cur_right = j;
            } else {
                right[j] = Math.min(right[j], cur_right);
            }
        }

        for (let j = 0; j < n; j++) {
            maxArea = Math.max(maxArea, (right[j] - left[j]) * heights[j]);
        }
    }
    return maxArea;
}

console.log(mr([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]))
