/**

Given a string, sort it in decreasing order based on the frequency of characters.
 */

var frequencySort = function(s) {
    let sm = new Map();
    let resArray = [];
    let res = ""
    for (let c of s) {
        sm.set(c, sm.has(c)?sm.get(c) + 1 : 1);
    }
    for (let [k ,v] of sm) {
        resArray.push({
            'letter': k,
            'frequency': v
        });
    }
    resArray.sort((a, b) => (b.frequency - a.frequency))
    for (let el of resArray) {
        res += el.letter.repeat(el.frequency);
    }
    return res;
};

console.log(frequencySort('tree'));