/**
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 */

const repeatedStringMatch = (A, B) => {
    let la = A.length;
    let lb = B.length;
    let times_1 = Math.ceil(lb/la);

    let times_2 = Math.ceil(2*lb/la);

    if (A.repeat(times_1).indexOf(B) !== -1) return times_1;
    else {
        for (let i = times_1 + 1; i <= times_2; i++) {
            if (A.repeat(i).indexOf(B) !== -1) return i;
        }
    }
    return -1;
}

console.log(repeatedStringMatch('abababaaba', 'aabaaba'))
