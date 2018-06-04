/**
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */

var minPathSum = function(grid) {
    let rows = grid.length, cols = grid[0].length;
    let mp = new Array(rows);
    for (let i = 0; i < rows; i++) {
        mp[i] = new Array(cols);
        for (let j = 0; j < cols; j++) {
            mp[i][j] = 0;
        }
    }

    for (let i = 0; i < cols; i++) {
        mp[0][i] = grid[0][i] + (i === 0 ? 0 : mp[0][i-1]);
    }
    for (let i = 1; i < rows; i++) {
        mp[i][0] = grid[i][0] + mp[i-1][0];
    }

    for (let i = 1; i < rows; i++) {
        for (let j = 1; j < cols; j++) {
            mp[i][j] = Math.min(mp[i-1][j], mp[i][j-1]) + grid[i][j];
        }
    }

    return mp[rows-1][length-1];

};