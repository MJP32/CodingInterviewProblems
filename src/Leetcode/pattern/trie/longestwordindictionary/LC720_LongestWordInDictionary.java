package Leetcode.pattern.trie.longestwordindictionary;

import java.util.HashMap;
import java.util.Stack;

public class LC720_LongestWordInDictionary {
    public static void main(String[] args) {
        LC720_LongestWordInDictionary lc720 = new LC720_LongestWordInDictionary();
        //System.out.println(lc720.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(lc720.longestWord(new String[]{"b", "br", "bre", "brea", "break", "breakf", "breakfa", "breakfas", "breakfast", "l", "lu", "lun", "lunc", "lunch", "d", "di", "din", "dinn", "dinne", "dinner"}));

    }

    private String longestWord(String[] words) {
        Trie trie = new Trie();
        int index  =0;
        for (String word : words){
            trie.insert(word,++index);
        }
        trie.words = words;
        return trie.dfs();
    }


}

class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    int end;

    public TrieNode(char c) {
        this.c = c;
    }

}

class Trie {
    TrieNode root;
    String[] words;

    public Trie() {
        root = new TrieNode('0');
    }

    public void insert(String word, int index) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode(c));
            curr = curr.children.get(c);
        }
        curr.end = index;
    }

    public String dfs() {
        String ans = "";
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TrieNode node = stack.pop();
            if (node.end > 0 || node == root) {
                if (node != root) {
                    String word = words[node.end - 1];
                    if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
                        ans = word;
                    }
                }
                for (TrieNode nei : node.children.values()) {
                    stack.push(nei);
                }
            }
        }
        return ans;
    }
}