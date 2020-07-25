package Leetcode.topic.stg;

public class LC208_ImplementTrie {
    public static void main(String[] args) {

//        String[] words = new String[]{"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEAATED",
//                "NOTRE_PEATED"};
//
//        Trie trie = new Trie();
//        for (String word : words) {
//            trie.insert(word);
//        }

        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}
