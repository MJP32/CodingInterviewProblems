package Leetcode.pattern.trie.IndexPairsOfAString2;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word;
}
