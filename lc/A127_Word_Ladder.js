/**
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 */

const ladderLength = (beginWord, endWord, wordList) => {
    let queue = [beginWord], length = 0;
    let distance = [];
    distance[beginWord] = 0;
    while (queue.length > 0) {
        let curr = queue.shift();
        if (curr === endWord) break;
        for (let i = 0; i < wordList.length; i++) {
            if (wordList[i] !== '#' && diffOneLetter(curr, wordList[i])) {
                let tmp = wordList[i];
                distance[tmp] = distance[curr] + 1;
                wordList[i] = '#';
                queue.push(tmp);
            }
        }
    }

    return distance[endWord] + 1 || 0;
}

const diffOneLetter = (s, p) => {
    let counter = 0;
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) !== p.charAt(i)) {
            counter++;
            if (counter > 1) return false;
        }
    }
    return counter === 1;
}

console.log(ladderLength('aa', 'bc', ["ab","ba","cc"]))