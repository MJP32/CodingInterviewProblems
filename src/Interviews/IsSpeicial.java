package Interviews;

import java.util.*;
import java.util.stream.Collectors;

public class IsSpeicial {
    public static void main(String[] args) {
        String[] strings = new String[]{
                "foobarbaz",
                "foo",
                "bar",
                "foobarfoo",
                "baz",
                "foobaz",
                "foofoofoo",
                "foobazar",
        };
        specialStrings(strings).forEach(k-> System.out.println(k));
    }

    public static List<String> specialStrings(String[] strings) {
        Trie trie = new Trie();

        for (String str : strings){
            trie.insert(str);
        }

        return Arrays.asList(strings).stream()
                .filter(string->isSpecial(string, trie.root, 0,0,trie))
                .collect(Collectors.toList());
    }

    private static boolean isSpecial(String string, TrieNode trieNode, int idx, int count, Trie trie) {

        char c = string.charAt(idx);
        if (!trieNode.children.containsKey(c)) {
            return false;
        }

        TrieNode nextTrieNode = trieNode.children.get(c);
        boolean atEndOfString = idx == string.length()-1;
        if (atEndOfString) {
            return nextTrieNode.children.containsKey(trie.endSymbol) && count+1 >=2;
        }
        if (nextTrieNode.children.containsKey(trie.endSymbol)) {
            boolean restIsSpecial = isSpecial(string, trie.root, idx +1, count+1, trie);
            if (restIsSpecial) {
                return true;
            }

        }
        return isSpecial(string, nextTrieNode, idx+1, count, trie);
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();

    }

    static class Trie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public void insert(String string) {
            TrieNode current = root;
            for (int i = 0; i < string.length(); i++) {
                char letter = string.charAt(i);
                if (!current.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    current.children.put(letter, newNode);
                }
                current = current.children.get(letter);
            }
            current.children.put(endSymbol, null);
        }

    }

}
