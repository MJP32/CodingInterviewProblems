package AlgoExpert.trie.multistringsearch;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word;
}
