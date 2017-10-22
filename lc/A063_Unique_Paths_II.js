/**
Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */

var uniquePathsWithObstacles = function(obstacleGrid) {
    let rows = obstacleGrid.length, cols = obstacleGrid[0].length;
    let matrix = new Array(rows);
    for (let i = 0; i < rows; i++) {
        matrix[i] = new Array(cols);
        for (let j = 0; j < cols; j++) {
            matrix[i][j] = 0;
        }
    }
    for (let i = 1; i < cols; i++) {
        if (obstacleGrid[0][i] === 1) break;
        matrix[0][i] = 1;
    }

    for (let i = 1; i < rows; i++) {
        if (obstacleGrid[i][0] === 1) break;
        matrix[i][0] = 1;
    }

    for (let i = 1; i < rows; i++) {
        for (let j = 1; j < cols; j++) {
            matrix[i][j] = obstacleGrid[i][j] === 1 ? 0 : matrix[i-1][j] + matrix[i][j-1];
        }
    }

    return matrix[rows - 1][cols - 1];
};

console.log(uniquePathsWithObstacles([]))