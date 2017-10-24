

var maxProfit = function(prices, fee) {
    let days = prices.length;
    if (days <= 1) return 0;
    let buy = new Array(days), hold = new Array(days), skip = new Array(days), sell = new Array(days);
    
    buy[0] = -prices[0];
    hold[0] = -prices[0];
    skip[0] = 0;

    for (let i = 1; i < days; i++) {
        if (i === 1) {
            buy[1] = -prices[1];
            skip[1] = 0;
        } else {
            buy[i] = Math.max(skip[i - 1], sell[i - 1]) - prices[i];
            skip[i] = Math.max(skip[i - 1], sell[i - 1]);
        }
        hold[i] = Math.max(hold[i - 1], buy[i - 1]);
        sell[i] = Math.max(hold[i - 1], buy[i - 1]) + prices[i] - fee;
    }
    
    return Math.max(skip[days - 1], sell[days - 1], 0);
};


const mp = (prices, fee) => {
    // s0: 当前不持有股票时最大利润, s1: 当前持有股票时的最大利润
    let s0 = 0, s1 = -100000;Number.NEGATIVE_INFINITY
    for (let p of prices) {
        // 考虑每一天后的最大利润
        // 更新s0，相当于在s1的基础上卖掉当前股票；更新s1，相当于在s0的基础上购买当前股票
        let tmp = s0;
        s0 = Math.max(s0, s1 + p - fee);
        s1 = Math.max(s1, tmp - p);
    }

    return s0;
}

console.log(mp([1, 3, 2, 8, 4, 9], 2))