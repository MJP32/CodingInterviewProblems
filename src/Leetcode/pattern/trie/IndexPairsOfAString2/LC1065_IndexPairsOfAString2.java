package Leetcode.pattern.trie.IndexPairsOfAString2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1065_IndexPairsOfAString2 {
    public static void main(String[] args) {
        String bigString = "thestoryofleetcodeandme";
        String[] smallString = new String[]{"story","fleet","leetcode"};
        System.out.println(Arrays.deepToString(multiStringSearch(bigString, smallString)));
    }
    public static int[][] multiStringSearch(String bigString, String[] smallStrings) {
        Trie trie = new Trie();

        for(String smallString : smallStrings){
            trie.insert(smallString);
        }
       List<int[]> result = new ArrayList<>();

        for(int i =0; i < bigString.length();i++){
            findSmallStringsIn(bigString, i, trie, result);
        }

        return result.toArray(new int[result.size()][]);
    }
    public static void findSmallStringsIn(String str, int startIdx,Trie trie, List<int[]> res){
        TrieNode currentNode = trie.root;
        for(int i = startIdx; i < str.length(); i++){
            char currentChar = str.charAt(i);
            if(!currentNode.children.containsKey(currentChar)){
                break;
            }
            currentNode = currentNode.children.get(currentChar);
            if(currentNode.children.containsKey(trie.endSymbol)){
                res.add(new int[]{startIdx, i});
            }
        }
    }
}
