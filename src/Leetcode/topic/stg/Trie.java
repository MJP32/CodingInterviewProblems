package Leetcode.topic.stg;

import java.util.HashMap;
import java.util.Map;

class Trie {
    TrieNode root;
    char endSymbol;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        endSymbol = '*';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                TrieNode newNode = new TrieNode();
                node.children.put(letter, newNode);
            }
            node= node.children.get(letter);
        }
        node.children.put(this.endSymbol, null);
        node.word = word;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = this.root;
        if(node.children.size() == 0){
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if(node.children.containsKey(i)){
                return false;
            }
            node = node.children.get(letter);
        }
        return node.children.containsKey(endSymbol);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode node = this.root;
        if(node.children.size() == 0){
            return false;
        }
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if(node.children.containsKey(i)){
                return false;
            }
        }
        return true;

    }

    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        String word ="";


    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */