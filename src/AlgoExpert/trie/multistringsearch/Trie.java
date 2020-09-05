package AlgoExpert.trie.multistringsearch;

public class Trie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public void insert(String str){
        TrieNode node = root;
        for(int i =0; i < str.length(); i++){
            char letter = str.charAt(i);
            if(!node.children.containsKey(letter)){
                TrieNode newNode = new TrieNode();
                node.children.put(letter, newNode);
            }
            node = node.children.get(letter);
        }
        node.children.put(endSymbol, null);
        node.word = str;
    }
}
