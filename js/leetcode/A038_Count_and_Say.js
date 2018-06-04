

var countAndSay = function(n) {
    if (n == 1) return '1';
    else return conversion(countAndSay(n - 1));
};

const conversion = (s) => {
    if (s.length === 1) return '11';
    let ns = '';
    let count = 0;
    let temp = null;
    for (let i = 0; i < s.length; i++) {
        count++;
        if (temp && s.charAt(i) !== temp) {
            ns += (count - 1) + temp;
            count = 1;
        }
        if (i === s.length - 1)  ns += count + s.charAt(s.length - 1);
        temp = s.charAt(i);
    }
    return ns;
}

console.log('====================================');
console.log(countAndSay(4));
console.log('====================================');