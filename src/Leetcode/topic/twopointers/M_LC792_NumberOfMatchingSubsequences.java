package Leetcode.topic.twopointers;

import Leetcode.common.Node;

import java.util.ArrayList;

public class M_LC792_NumberOfMatchingSubsequences {
    public static void main(String[] args) {
/*
     Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

    Example :
    Input:
    S = "abcde"
    words = ["a", "bb", "acd", "ace"]
    Output: 3
    Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".

*/
        System.out.println(new M_LC792_NumberOfMatchingSubsequences().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));

    }
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Node>();

        for (String word: words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));

        for (char c: S.toCharArray()) {
            ArrayList<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node: old_bucket) {
                node.val++;
                if (node.val == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.val) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }
}
