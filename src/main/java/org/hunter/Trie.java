package org.hunter;

import java.util.HashSet;
import java.util.Set;

class Trie {

    private Set<String> words;
    private Set<String> prefixes;

    public Trie() {
        words = new HashSet<>();
        prefixes = new HashSet<>();
    }

    public void insert(String word) {
        words.add(word);
        for(int i = 0; i < word.length(); ++i) {
            prefixes.add(word.substring(0, i + 1));
        }
    }

    public boolean search(String word) {
        return words.contains(word);
    }

    public boolean startsWith(String prefix) {
        return prefixes.contains(prefix);
    }
}