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


const e2 = (board, word) => {

    if (board === null || board.length === 0) return false;
    let n = board.length, m = board[0].length, result = false;
    let isVisited = new Array(n);
    for (let i = 0; i < n; i++) {
        isVisited[i] = new Array(m).fill(false);
    }
    const dfs = (i, j, counter) => {
        if (counter === word.length) return true;
        if (j < m - 1 && !isVisited[i][j + 1] && board[i][j + 1] === word.charAt(counter)) {
            isVisited[i][j + 1] = true;
            if (dfs(i, j + 1, counter + 1)) return true;
            isVisited[i][j + 1] = false;
        }
        
        if (j > 0 && !isVisited[i][j - 1] && board[i][j - 1] === word.charAt(counter)) {
            isVisited[i][j - 1] = true;
            if (dfs(i, j - 1, counter + 1)) return true;
            isVisited[i][j - 1] = false;
        }
        
        if (i < n - 1 && !isVisited[i + 1][j] && board[i + 1][j] === word.charAt(counter)) {
            isVisited[i + 1][j] = true;
            if (dfs(i + 1, j, counter + 1)) return true;
            isVisited[i + 1][j] = false;
        }
        
        if (i > 0 && !isVisited[i - 1][j] && board[i - 1][j] === word.charAt(counter)) {
            isVisited[i - 1][j] = true;
            if (dfs(i - 1, j, counter + 1)) return true;
            isVisited[i - 1][j] = false;
        }
        return false;
    }
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if(board[i][j] === word.charAt(0)) {
                isVisited[i][j] = true;
                if (dfs(i, j, 1)) return true;
                isVisited[i][j] = false;
            }
        }
    }

    return false;
}

// console.log(exist([["a","b"],["d","c"]], "abcde"))
// console.log(exist([['a', 'a']], 'aaa'))
// console.log(e2([["C","A","A"],["A","A","A"],["B","C","D"]], "AAB"))
console.log(e2([["B","A","A"]], "AAB"))