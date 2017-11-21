/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

const isValid = (s) => {
    let m = {
        ')' : '(',
        ']' : '[',
        '}' : '{'
    };
    let stack = [];
    return Array.from(s).every(val => {
        if (val === '(' || val === '[' || val === '{') {
            stack.push(val);
            return true;
        }
        return stack.pop() === m[val];
    }) && stack.length === 0;
}