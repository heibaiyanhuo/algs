/**
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.
 */

const mp = (prices, fee) => {
    let mp0 = 0, mp1 = Number.MIN_SAFE_INTEGER;
    for (let price of prices) {
        [mp0, mp1] = [Math.max(mp0, mp1 + price - fee), Math.max(mp1, mp0 - price)];
    }
    return mp0;
}