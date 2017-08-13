/**
Given numRows, generate the first numRows of Pascal's triangle.
 */

var generate = function(numRows) {
    if (numRows === 0) return [];
    let res = [[1]];
    for (let i = 0; i < numRows - 1; i++) {
        gp(res);
    }
    return res;
};

var gp = function(a) {
    let b = a[a.length - 1];
    let c = [1];
    for (let i = 0; i < b.length - 1; i++) {
        c.push(b[i] + b[i + 1]);
    }
    c.push(1);
    a.push(c);
}