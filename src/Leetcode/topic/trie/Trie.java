package Leetcode.topic.trie;

public class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            TrieNode node = current.children.get(character);
            if(node == null){
                node = new TrieNode();
                current.children.put(character, node);
            }
            current = node;



        }
        current.isWord = true;

    }

    public boolean search(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if(current.children.containsKey(character)){
                current = current.children.get(character);
            }
            else{
                return false;
            }
        }
        if (current.isWord == true) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix){
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character character = prefix.charAt(i);
            if (current.children.containsKey(character)) {
                current = current.children.get(character);
            }
            else {
                return false;
            }

        }
        return true;
    }
}
