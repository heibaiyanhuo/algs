/**
Implement pow(x, n).
 */


const myPow = (x, n) => {
    let m = true;
    if (n < 0) {
        m = false;
        n = -n;
    }
    return m? p(x, n) : -1 * p(x, n);
    
}

const p = (x, n) => {
    if (n === 1) return x;
    if (n%2 === 0) return myPow(x*x, n/2);
    else return x*myPow(x*x, (n-1)/2);
}

console.log(myPow(2, 5))