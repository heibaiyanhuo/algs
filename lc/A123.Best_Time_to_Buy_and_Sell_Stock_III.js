/**
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

const maxProfit = (prices) => {
    let buy1 = Number.MIN_SAFE_INTEGER, buy2 = Number.MIN_SAFE_INTEGER;
    let sell1 = 0, sell2 = 0;
    for (let p of prices) {
        buy1 = Math.max(buy1, -p);
        sell1 = Math.max(sell1, buy1 + p);
        buy2 = Math.max(buy2, sell1 - p);
        sell2 = Math.max(sell2, buy2 + p);
    }
    return sell2;
}