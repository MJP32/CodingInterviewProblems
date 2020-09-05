package AlgoExpert.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode{
    char c;
    Map<Character,TrieNode> children;
    boolean isWord;

    public TrieNode(char c){
        this.c = c;
        children = new HashMap<>();
    }

    public TrieNode(){
        children = new HashMap<>();
    }
}
