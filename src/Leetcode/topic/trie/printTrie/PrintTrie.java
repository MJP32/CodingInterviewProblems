package Leetcode.topic.trie.printTrie;

import java.util.HashMap;
import java.util.Map;

public class PrintTrie {


    public static void main(String[] args) {
        String[] smallStrings = {"this","than", "yo", "is", "a", "bigger", "string", "kappa"};
        buildTree(smallStrings);
    }
    public static void buildTree(String[] smallStrings) {
        Trie trie = new Trie();
        for (String str : smallStrings) {
            trie.insert(str);
        }
        
//        printTrie(trie)
    }

    private static void printTrie(Trie trie) {
        
    }

}


class Trie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public void insert(String str) {
        TrieNode current = root;
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!current.children.containsKey(letter)) {
                TrieNode newNode = new TrieNode();
                current.children.put(letter, newNode);
            }

            current = current.children.get(letter);


        }
        current.children.put(endSymbol, null);
        current.word = str;


    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word;

}


