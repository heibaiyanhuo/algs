/**
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 */


var generateMatrix = function(n) {
    let matrix = new Array(n);
    for (let i = 0; i < n; i++) {
        matrix[i] = new Array(n).fill(0);
    }
    
    let rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
    let number = 1;
    while (rowBegin <= rowEnd && colBegin <= colEnd) {
        for (let i = colBegin; i <= colEnd; i++) {
            matrix[rowBegin][i] = number++
        }
        rowBegin++;

        for (let i = rowBegin; i <= rowEnd; i++) {
            matrix[i][colEnd] = number++;
        }
        colEnd--;

        if (rowBegin <= rowEnd) {
            for (let i = colEnd; i >= colBegin; i--) {
                matrix[rowEnd][i] = number++;
            }
        }
        rowEnd--;

        if (colBegin <= colEnd) {
            for (let i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin] = number++;
            }
        }
        colBegin++;
    }
    return matrix;
};


console.log(generateMatrix(2))