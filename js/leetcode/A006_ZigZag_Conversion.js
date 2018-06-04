

var convert = function(s, numRows) {
    let godown = true;
    let res = [], i = 0;
    for (let c of s) {
        res[i] = res[i] || '';
        res[i] += c;
        if (godown) {
            i++;
        } else {
            i--;
        }
        if(i === numRows - 1 || i === 0) godown = !godown;
    }
    return res.join('');
};

console.log('====================================');
console.log(convert("PAYPALISHIRING", 3));
console.log('====================================');