package leetcode.problems;


import leetcode.datastructures.TrieNode;

public class A208_Implement_Trie {
    TrieNode root;

    public A208_Implement_Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return helper(word, false);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return helper(prefix, true);
    }

    private boolean helper(String word, boolean isPrefix) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return isPrefix || curr.end;
    }
}
