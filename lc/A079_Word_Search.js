/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */

var exist = function(board, word) {
    if (board.length === 0) return false;
    let passed = new Array(board.length);
    for (let i = 0; i < board.length; i++) {
        passed[i] = new Array(board[0].length).fill(false);
    }

    let r = {
        exist: false
    }

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            if (board[i][j] === word.charAt(0)) {
                console.log(i + '....' + j + '....' + board[i][j])
                passed[i][j] = true;
                backtrack(r, i, j, board, 1, word, passed);
                passed[i][j] = false;
            }
        }
    }
    return r.exist;
}; 

const backtrack = (r, bi, bj, board, i, word, passed) => {
    console.log(passed)
    if (r.exist) return;
    if (i === word.length) {
        r.exist = true;
        return;
    }


    if (bj < board[0].length - 1 && !passed[bi][bj+1] && board[bi][bj+1] === word.charAt(i)) {
        // console.log('1' + '...' + i)
        passed[bi][bj+1] = true;
        backtrack(r, bi, bj+1, board, i+1, word, passed);
        passed[bi][bj+1] = false;
    } 
    if (bj > 0 && !passed[bi][bj-1] && board[bi][bj-1] === word.charAt(i)) {
        // console.log('2' + '...' + i)
        passed[bi][bj-1] = true;
        backtrack(r, bi, bj-1, board, i+1, word, passed);
        passed[bi][bj-1] = false;
    } 
    if (bi < board.length - 1 && !passed[bi+1][bj] && board[bi+1][bj] === word.charAt(i)) {
        // console.log('3' + '...' + i)
        passed[bi+1][bj] = true;
        backtrack(r, bi+1, bj, board, i+1, word, passed);
        passed[bi+1][bj] = false;
    }
    if (bi > 0 && !passed[bi-1][bj] && board[bi-1][bj] === word.charAt(i)) {
        // console.log('4' + '...' + i)
        passed[bi-1][bj] = true;
        backtrack(r, bi-1, bj, board, i+1, word, passed);
        passed[bi-1][bj] = false;
    } 

    return;
}


// console.log(exist([["a","b"],["d","c"]], "abcde"))
// console.log(exist([['a', 'a']], 'aaa'))
console.log(exist([["C","A","A"],["A","A","A"],["B","C","D"]], "AAB"))