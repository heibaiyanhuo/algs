/**
Given a digit string, return all possible letter combinations that the number could represent.
 */


const m = {
  '1': ['*'],
  '2': ['a', 'b', 'c'],
  '3': ['d', 'e', 'f'],
  '4': ['g', 'h', 'i'],
  '5': ['j', 'k', 'l'],
  '6': ['m', 'n', 'o'],
  '7': ['p', 'q', 'r', 's'],
  '8': ['t', 'u', 'v'],
  '9': ['w', 'x', 'y', 'z']
}

const letterCom = (digits) => {

  if (digits.indexOf('0') !== -1) return [];
  let result = [];
  for(let c1 of digits) {
    
    let length = result.length;
    if (length == 0) {
      result = Array.from(m[c1]);
      continue;
    }

    let i = 0;
    while (i++ < length) {
      let temp = result.shift();
      for(let c2 of m[c1]) {
        result.push(temp + c2)
      }
    }
  }

  return result;
}

console.log(letterCom('22'))