/**
Count the number of prime numbers less than a non-negative number, n.
 */

var countPrimes = function(n) {
    let isPrime = new Array(n).fill(true);
    let count = 0;
    for (let i = 2; i * i < n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        } else {
            continue;
        }
    }
    for (let i = 2; i < n; i++) {
        if (isPrime[i]) count++;
    }
    return count;
};

console.log('====================================');
console.log(countPrimes(3));
console.log('====================================');