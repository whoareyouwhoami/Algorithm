package com.algorithm.string;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrieTest {

    @Test
    public void testInsert() {
        String[] insertWord = {"hello", "world", "this", "is", "programming"};
        Trie trie = new Trie();
        trie.root = new TrieNode();
        for(String inserting: insertWord)
            trie.insert(inserting);

        List<String> result = new ArrayList<>();
        trie.printTrie(trie.root, "", result);

        List<String> answer = new ArrayList<>();
        String[] answerWord = {"hello", "is", "programming", "this", "world"};
        Collections.addAll(answer, answerWord);

        for(int i = 0; i < answerWord.length; i++) {
            assertThat(result.get(i), is(answer.get(i)));
        }
    }

    @Test
    public void testSearch() {
        String[] insertWord = {"hello", "world", "this", "is", "programming"};
        Trie trie = new Trie();
        trie.root = new TrieNode();
        for(String inserting: insertWord)
            trie.insert(inserting);

        String[] searchWord = {"hello", "what", "program", "are", "this"};
        boolean[] answer = {true, false, false, false, true};
        for(int i = 0; i < searchWord.length; i++) {
            assertThat(trie.search(searchWord[i]), is(answer[i]));
        }
    }

    @Test
    public void testDelete() {
        String[] insertWord = {"hello", "world", "this", "thisis", "programming"};
        Trie trie = new Trie();
        trie.root = new TrieNode();
        for(String inserting: insertWord)
            trie.insert(inserting);

        trie.delete(trie.root, "this", 0);

        List<String> result = new ArrayList<>();
        trie.printTrie(trie.root, "", result);

        List<String> answer = new ArrayList<>();
        String[] answerWord = {"hello", "programming", "thisis", "world"};
        Collections.addAll(answer, answerWord);

        for(int i = 0; i < answerWord.length; i++) {
            assertThat(result.get(i), is(answer.get(i)));
        }
    }
}
