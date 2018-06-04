/**
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */

var spiralOrder = function(matrix) {
    let result = [];
    let rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;

    while (rowBegin <= rowEnd && colBegin <= colEnd) {
        for (let i = colBegin; i <= colEnd; i++) {
            result.push(matrix[rowBegin][i]);
        }
        rowBegin++;

        for (let i = rowBegin; i < rowEnd; i++) {
            result.push(matrix[i][colEnd]);
        }
        colEnd--;

        if (rowBegin <= rowEnd) {
            for (let i = colEnd; i >= colBegin; i--) {
                result.push(matrix[rowEnd][i]);
            }
        }
        rowEnd--;

        if (colBegin <= colEnd) {
            for (let i = rowEnd; i >= rowBegin; i--) {
                result.push(matrix[i][colBegin]);
            }
        }
        colBegin++;
    }
    return result;
};

console.log()