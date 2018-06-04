/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

 */

var searchMatrix = function(matrix, target) {
    if (matrix.length === 0 || matrix[0].length === 0) return false;
    let rows = matrix.length, cols = matrix[0].length;
    if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) return false;

    let lo = 0, hi = rows - 1;
    while (lo <= hi ) {
        let mid = Math.floor((lo + hi)/2);
        if (matrix[mid][0] === target) return true;
        if (matrix[mid][0] > target) hi = mid - 1;
        else lo = mid + 1;
    }
    targetRowIn = lo - 1;
    console.log(targetRowIn)
    lo = 0, hi = cols - 1;
    while (lo <= hi) {
        let mid = Math.floor((lo + hi)/2);
        if (matrix[targetRowIn][mid] === target) return true;
        if (matrix[targetRowIn][mid] > target) hi = mid - 1;
        else lo = mid + 1;
    }
    return false;
};

console.log(searchMatrix([[1, 3]], 3));