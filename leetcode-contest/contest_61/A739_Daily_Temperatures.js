/**
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you * * * would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, * 1, 0, 0].
 */

var dailyTemperatures = function(temperatures) {
    let ret = new Array(temperatures.length).fill(0);
    let aux = [];
    for (let i = 0; i < temperatures.length; i++) {
        while (aux.length !== 0 && temperatures[i] > temperatures[aux[aux.length - 1]]) {
            let idx = aux.pop();
            ret[idx] = i - idx;
        }
        aux.push(i);
    }

    return ret;
};