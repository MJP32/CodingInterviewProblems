package Leetcode.topic.trie;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        TrieNode current = root;
        for(int i =0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null){
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchRecursive(root, word, 0);
    }

    public boolean searchRecursive(TrieNode current, String word, int index){
        if(index == word.length()){
            return current.endOfWord;
        }
        char c = word.charAt(index);
        if(current.children.containsKey(c)){
            return searchRecursive(current.children.get(c), word, index +1);
        }
        else if(c == '.'){
            boolean result = false;
            for(Map.Entry<Character,TrieNode> child : current.children.entrySet()){
                if(index == word.length() -1){
                    return child.getValue().endOfWord;
                }
                if(searchRecursive(child.getValue(), word, index +1)){
                    result = true;
                }
            }
            return result;
        }
        else{
            return false;
        }
    }

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean endOfWord;
        TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */