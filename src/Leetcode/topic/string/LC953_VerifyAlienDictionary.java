package Leetcode.topic.string;



import java.util.Arrays;

public class LC953_VerifyAlienDictionary {
    public static void main(String[] args) {
        /*
        In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
        The order of the alphabet is some permutation of lowercase letters.

        Given a sequence of words written in the alien language, and the order of the alphabet,
        return true if and only if the given words are sorted lexicographicaly in this alien language.

        Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
        Output: true
        Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
        */

        System.out.println(new LC953_VerifyAlienDictionary().isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
    public int[] charMap;
    public boolean isAlienSorted(String[] words, String order) {
        charMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charMap[order.charAt(i) - 'a'] = i;

        }
        System.out.println(Arrays.toString(charMap));
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i-1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String word1, String word2) {
        int i =0;
        int j =0;
        int charCompareVal =0;
        while (i < word1.length() && j < word2.length() && charCompareVal ==0) {
            charCompareVal = charMap[word1.charAt(i) -'a'] - charMap[word2.charAt(j) -'a'];
            i++;
            j++;
        }
        if (charCompareVal ==0) {
            return word1.length()-word2.length();
        }
        else{
            return charCompareVal;
        }
    }
}
