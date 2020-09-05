package Leetcode.topic.trie;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PossibleStrings {
    public static void main(String[] args) {
        /*
        There is a broken keyboard in which space gets typed when you type the letter 'e'. Given an input string which is the output from the keyboard. A dictionary of possible words is also provided as an input parameter of the method. Return a list of possible actual input typed by the user.

        Example Input: String: "can s r n " Dictionary: ["can", "canes", "serene", "rene", "sam"]
        Expected Output: ["can serene", "canes rene"]
        
        
        */
        
    }
    
    
    public List<String> getPossibleInputs(String s, List<String> dict){
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        buildTrie(root, dict);

        getPossibleStrings(0, s, new StringBuilder(), root, res);

        return res;
    }

    private void getPossibleStrings(int pos, String s, StringBuilder sb, TrieNode root, List<String> res) {

    }

    private void buildTrie(TrieNode root, List<String> dict) {
        for (String s : dict) {
            TrieNode curr = root;
            char c =' ';
//            for (char c : s.toCharArray()) {
                Map<Character, TrieNode> children = curr.children;
                children.putIfAbsent(c, new TrieNode(c));
                curr = children.get(c);
           // }
//            curr.isWord = true;
        }
    }
}
