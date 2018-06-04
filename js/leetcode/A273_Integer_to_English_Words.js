/**
 * Convert a non-negative integer to its english words representation.
 */

const D1 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen'];
const D2 = ['', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety'];
const D3 = ['', 'Thousand', 'Million', 'Billion'];

const numberToWords = (num) => {
    if (num === 0) return 'Zero';
    let res = '', i = 0;

    const convert = (num) => {
        if (num === 0) return '';
        else if (num < 20) return D1[num] + ' ';
        else if (num < 100) return D2[~~(num/10)] + ' ' + convert(num % 10);
        else {
            return D1[~~(num/100)] + ' Hundred ' + convert(num % 100);
        }
    }
    while (num > 0) {
        if (num % 1000 !== 0) {
            res = convert(num % 1000) + D3[i] + ' ' + res;
        }
        num = ~~(num/1000);
        i++;
    }
    return res;
}
console.log(numberToWords(1234))