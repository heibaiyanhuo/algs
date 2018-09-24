package leetcode.problems;

import leetcode.datastructures.TrieNode;

public class A211_Add_and_Search_Word {
    TrieNode root;
    public A211_Add_and_Search_Word() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    @SuppressWarnings("Duplicates")
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.end = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] word, int start, TrieNode node) {
        if (start == word.length) {
            return node.end;
        }
        if (word[start] != '.') {
            return node.children[word[start] - 'a'] != null && dfs(word, start + 1, node.children[word[start] - 'a']);
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && dfs(word, start + 1, node.children[i])) {
                return true;
            }
        }
        return false;
    }
}
