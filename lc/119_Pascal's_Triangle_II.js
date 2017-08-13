/**
Given an index k, return the kth row of the Pascal's triangle.
 */

var getRow = function(rowIndex) {
    let res = [1];
    for (let i = 0; i < rowIndex; i++) {
        res.unshift(1);
        for (let j = 1; j < res.length - 1; j++) {
            res[j] += res[j+1];
        }

    }
    return res;
};

console.log(getRow(3));