package Leetcode.zap.todo.review.facebook;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC953_VerifyAlienDictionary {
    public static void main(String[] args) {

        System.out.println(new LC953_VerifyAlienDictionary().isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
    public int[] charMap;
    public boolean isAlienSorted(String[] words, String order) {

//        Map<Character,Integer> alphabet = new HashMap<>();
//
//
//        for (int i = 0; i < order.length(); i++) {
//            alphabet.put(order.charAt(i), i);
//        }
//
//        alphabet.forEach((key, value) -> System.out.println(key + " : " + value));

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
