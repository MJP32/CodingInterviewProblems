package Leetcode.pattern.trie.indexpairsofstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1065_IndexPairsOfAString {
    public static void main(String[] args) {
        String text = "thestoryofleetcodeandme";
        String []words = new String[]{"story","fleet","leetcode"};

        System.out.println(Arrays.deepToString(new LC1065_IndexPairsOfAString().indexPairs(text,words)));
    }
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> res = new ArrayList<>();


        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }

        for (int i = 0; i < text.length(); i++) {

            TrieNode ptr = t.root;
            int j = i;
            while (j < text.length() && ptr.children[text.charAt(j)-'a'] != null) {
                ptr = ptr.children[text.charAt(j) - 'a'];
                if (ptr.endsHere >0){
                    res.add(new int[]{i,j});
                }
                j++;
            }

        }

        return res.toArray(new int[res.size()][]);
    }
}

class TrieNode{
   char letter;
   int endsHere;
   String word;
   TrieNode[] children;

    public TrieNode(char letter, int endsHere) {
        this.letter = letter;
        this.endsHere = endsHere;
        this.word = "";
        this.children = new TrieNode[26];
    }
}
class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode('*', 0);
    }

    public void insert(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode(c, 0);
            }
            curr = curr.children[c-'a'];
        }
        curr.endsHere++;
        curr.word = word;
    }


}