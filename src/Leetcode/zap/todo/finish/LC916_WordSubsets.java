package Leetcode.zap.todo.finish;

import java.util.ArrayList;
import java.util.List;

public class LC916_WordSubsets {
    public static void main(String[] args) {
      /*
        We are given two arrays A and B of words.  Each word is a string of lowercase letters.

        Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

        Now say a word a from A is universal if for every b in B, b is a subset of a.

        Return a list of all universal words in A.  You can return the words in any order.



        Example 1:

        Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
        Output: ["facebook","google","leetcode"]
        Example 2:

        Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
        Output: ["apple","google","leetcode"]
        Example 3:

        Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
        Output: ["facebook","google"]
        Example 4:

        Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
        Output: ["google","leetcode"]
        Example 5:

        Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
        Output: ["facebook","leetcode"]
      */
        new LC916_WordSubsets().wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"}).forEach(k -> System.out.println(k));
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int[] maxBFrequencies = new int[26];

        for (int i = 0; i < B.length; i++) {
            String currWord = B[i];
            int[] charFrequencies = getCharFrequency(currWord);

            for (int j = 0; j < 26; j++) {
                maxBFrequencies[j] = Math.max(maxBFrequencies[j], charFrequencies[j]);
            }
        }

        for (int i = 0; i < A.length; i++) {
            String currWord = A[i];
            int[] charCounts = getCharFrequency(currWord);
            boolean valid = true;

            for (int j = 0; j < 26; j++) {
                if (maxBFrequencies[j] > charCounts[j]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(currWord);
            }
        }
        return result;
    }

    public int[] getCharFrequency(String S) {
        int[] result = new int[26];
        for (char c : S.toCharArray()) {
            result[c - 'a']++;
        }
        return result;

    }
}
