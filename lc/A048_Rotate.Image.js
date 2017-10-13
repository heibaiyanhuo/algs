/**
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).
 */

var rotate = function(matrix) {
    matrix.reverse();
    let n = matrix.length;
    for (let i = 0; i < n - 1; i++) {
        for (let j = 1 + i; j < n; j++) {
            swap(matrix, i, j, j, i);
        }
    }
    return matrix;
};

const swap = (matrix, i1, j1, i2, j2) => {
    let temp = matrix[i1][j1];
    matrix[i1][j1] = matrix[i2][j2];
    matrix[i2][j2] = temp;
}

console.log(rotate([
    [1,2,3],
    [4,5,6],
    [7,8,9]
  ]
));