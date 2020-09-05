package AlgoExpert.trie.multistringsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiStringSearch {
    public static void main(String[] args) {
        String bigString = "This is a big string";
        String[] smallString = new String[]{"this","yo", "is", "a", "bigger", "string", "kappa"};
        multiStringSearch(bigString, smallString).forEach(k-> System.out.println(k));
    }
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        Trie trie = new Trie();

        for(String smallString : smallStrings){
            trie.insert(smallString);
        }
        Set<String> containedString = new HashSet<>();

        for(int i =0; i < bigString.length();i++){
            findSmallStringsIn(bigString, i, trie, containedString);
        }
        List<Boolean> solution = new ArrayList<>();
        for(String str: smallStrings){
            solution.add(containedString.contains(str));
        }

        return solution;
    }
    public static void findSmallStringsIn(String str, int startIdx, Trie  trie, Set<String> containedString){
        TrieNode currentNode = trie.root;
        for(int i = startIdx; i < str.length(); i++){
            char currentChar = str.charAt(i);
            if(!currentNode.children.containsKey(currentChar)){
                break;
            }
            currentNode = currentNode.children.get(currentChar);
            if(currentNode.children.containsKey(trie.endSymbol)){
                containedString.add(currentNode.word);
            }
        }
    }
}
