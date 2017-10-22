/**
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Notice: constant space solution.
 */

var setZeroes = function(matrix) {
    let fr = false, fc = false;
    let rows = matrix.length, cols = matrix[0].length;
    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if (matrix[i][j] === 0) {
                if (i === 0) fr = true;
                if (j === 0) fc = true;
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for (let i = 1; i < rows; i++) {
        for (let j = 1; j < cols; j++) {
            if (matrix[i][0] === 0 || matrix[0][j] === 0) matrix[i][j] = 0;
        }
    }

    if (fr) {
        for (let i = 0; i < cols; i++) matrix[0][i] = 0;
    }

    if (fc) {
        for (let i = 0; i < rows; i++) matrix[i][0] = 0;
    }
    console.log(fr + '...' + fc)
    
    return matrix;
};

console.log(setZeroes([[0], [1]]))