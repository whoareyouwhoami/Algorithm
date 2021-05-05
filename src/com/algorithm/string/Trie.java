package com.algorithm.string;

import java.util.List;

public class Trie {
    public TrieNode root;

    public void insert(String word) {
        TrieNode trie = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (trie.children[idx] == null)
                trie.children[idx] = new TrieNode();

            trie = trie.children[idx];
        }
        trie.isLastWord = true; // Mark last word
    }

    public boolean search(String word) {
        TrieNode trie = root;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(trie.children[idx] == null)
                return false;

            trie = trie.children[idx];
        }
        return trie.isLastWord;
    }

    public boolean delete(TrieNode trie, String word, int wordIdx) {
        if(word.length() == wordIdx) {
            trie.isLastWord = false;
            return noChildren(trie);
        }
        int idx = word.charAt(wordIdx) - 'a';
        if(trie.children[idx] == null)
            return false;

        boolean recursiveDelete = delete(trie.children[idx], word, wordIdx + 1);
        if(recursiveDelete) {
            if(trie.children[idx].isLastWord)
                return false;
            trie.children[idx] = null;
            return noChildren(trie);
        }
        return false;
    }

    private boolean noChildren(TrieNode node) {
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(node.children[i] != null) {
                count++;
            }
        }
        return count == 0;
    }

    public void printTrie(TrieNode trie, String word, List<String> words) {
        for(int i = 0; i < 26; i++) {
            if(trie.children[i] == null)
                continue;
            char c = (char) (97 + i);
            String w = word + c;
            if(trie.children[i].isLastWord)
                words.add(w);
            printTrie(trie.children[i], w, words);
        }
    }
}
