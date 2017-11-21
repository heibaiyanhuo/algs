

var selfDividingNumbers = function(left, right) {
    let r = [];
    for (let i = left; i <= right; i++) {
        if (isSDN(i)) r.push(i);
    }
    return r;
};

const isSDN = (number) => {
    if (number < 10) return true;
    let tmp = number;
    while (tmp >= 10) {
        let d = tmp % 10;
        if (d === 0 || number % d !== 0) return false;
        tmp = (tmp - d)/10;
    }
    return number % tmp === 0;
}

console.log(selfDividingNumbers(1, 22))