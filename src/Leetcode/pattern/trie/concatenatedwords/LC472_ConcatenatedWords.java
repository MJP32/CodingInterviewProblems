package Leetcode.pattern.trie.concatenatedwords;


import java.util.*;

public class LC472_ConcatenatedWords {
    public static void main(String[] args) {
        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat",
                "ratcatdogcat"};
        new LC472_ConcatenatedWords().findAllConcatenatedWordsInADict(words).forEach(k -> System.out.println(k));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        Trie trie = new Trie();
        TrieNode root = trie.root;
        for(String word : words){
            trie.insert(word);
        }

        for (String word : words) {
            if (canForm(word, trie)) {
                result.add(word);
            }
        }
        for (String word : words) {
            if (isConcatenated(word,0,0, root)) {
                result2.add(word);
            }
        }


        return result2;
    }

    private boolean isConcatenated(String word, int idx, int countConcatenatedWords, TrieNode root) {
        if (idx == word.length() && countConcatenatedWords > 2){
            return true;
        }
        TrieNode ptr= root;
        for (int i = idx; i < word.length(); i++) {
            if(!ptr.children.containsKey(word.charAt(i))){
                return false;
            }
            ptr = ptr.children.get(word.charAt(i));
            if(ptr.endOfWord){
                if(isConcatenated(word, i+1, countConcatenatedWords+1, root)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canForm(String word, Trie trie) {


        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (trie.search(left)) {
                if (trie.search(right) || (canForm(right, trie))) {
                    return true;
                }
            }
        }

        return false;
    }
}

