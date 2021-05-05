package com.algorithm.string;

public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isLastWord;

    public TrieNode() {
        isLastWord = false;
        for(int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
