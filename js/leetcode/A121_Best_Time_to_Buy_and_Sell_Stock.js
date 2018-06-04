/**
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */

var maxProfit = function(prices) {
    let a = 0, b = prices[0];
    for (let i = 1; i < prices.length; i++) {
        b = Math.min(b, prices[i]);
        a = Math.max(a, prices[i] - b);
    }
    return a;
};

console.log(maxProfit([7,6,4,3,1]));