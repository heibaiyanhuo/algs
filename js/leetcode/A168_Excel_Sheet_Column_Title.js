/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */

var convertToTitle = function(n) {
    let ret = '';
    while (n > 26) {
        let r = n % 26;
        if (r === 0) r = 26;
        ret = String.fromCharCode(r + 64); + ret;
        n = (n - r)/26;
    }
    if (n > 0) ret = String.fromCharCode(n + 64); + ret;
    return ret;
};

const toLetter = (n) => {
    return String.fromCharCode(n + 64);
}

console.log(convertToTitle(27))