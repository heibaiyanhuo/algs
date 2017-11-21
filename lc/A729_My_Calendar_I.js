

const MyCalendar = class {
    constructor () {
        this.bookingTime = [];
    }
}

MyCalendar.prototype.book = function (start, end) {
    let length = this.bookingTime.length;
    if (length === 0 || start >= this.bookingTime[length - 1][1]) {
        this.bookingTime.push([start, end]);
        return true;
    }
    
    if (end <= this.bookingTime[0][0]) {
        this.bookingTime.unshift([start, end]);
        return true;
    }

    let lo = 0, hi = length - 1;
    while (lo <= hi) {
        let mid = Math.floor((lo + hi) / 2);
        if (this.bookingTime[mid][0] === start) return false;
        if (this.bookingTime[mid][0] > start) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }

    if ((lo === 0 || start >= this.bookingTime[lo - 1][1]) && end <= this.bookingTime[lo][0]) {
        this.bookingTime.splice(lo, 0, [start, end]);
        return true;
    }
    return false;
}

let mc = new MyCalendar();
console.log(mc.book(37, 50));
console.log(mc.bookingTime)
console.log(mc.book(33, 50));
console.log(mc.bookingTime)

console.log(mc.book(4, 17));
// console.log(mc.book(5, 10));