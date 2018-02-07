

const canTransform = (start, end) => {
    if (start !== end) return false;
    if (start === end) {
        return true;
    }
    let q1 = [start];
    let q2 = [end];
    let res = new Set();
    
    console.log(1)
    while (q1.length > 0 && q2.length > 0) {
        let s = q1.shift();
        
        for (let i = 0; i < s.length - 1; i++) {
            if (s.substr(i, 2) === 'XL') {
                let tmp = s.substring(0, i) + 'LX' + s.substr(i + 2);
                if (!res.has(tmp)) {
                    q1.push(tmp);
                    res.add(tmp);
                }
            }
            if (s.substr(i, 2) === 'RX') {
                let tmp = s.substring(0, i) + 'XR' + s.substr(i + 2);
                if (!res.has(tmp)) {
                    q1.push(tmp);
                    res.add(tmp);
                }
            }
        }
        console.log(res.size())
        
        let e = q2.shift();

        if (res.has(e)) return true;
        for (let i = 0; i < e.length - 1; i++) {
            if (e.substr(i, 2) === 'LX') {
                let tmp = e.substring(0, i) + 'XL' + e.substr(i + 2);
                if (res.has(tmp)) return true;
                q2.push(tmp);
            }
            if (e.substr(i, 2) === 'XR') {
                let tmp = e.substring(0, i) + 'RX' + e.substr(i + 2);
                if (res.has(tmp)) return true;
                q2.push(tmp);
            }
        }
    }
    return false;
}

console.log(canTransform('XL', 'LX'));