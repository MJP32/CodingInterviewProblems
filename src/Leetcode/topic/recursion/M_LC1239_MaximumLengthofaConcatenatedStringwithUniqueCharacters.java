package Leetcode.topic.recursion;

import java.util.List;

public class M_LC1239_MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    public static void main(String[] args) {
        /*Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

        Return the maximum possible length of s.

        Input: arr = ["un","iq","ue"]
        Output: 4
        Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
        Maximum length is 4.

        */
        //System.out.println(new M_LC1239_MaximumLengthofaConcatenatedStringwithUniqueCharacters().maxLength());
    }
    public int maxLength(List<String> arr) {
        int[] result = new int[1];
        maxUnique(arr, 0, "", result);
        return result[0];
    }

    private void maxUnique(List<String> arr, int index, String current, int[] result) {
        if (index == arr.size() && uniqueCharsCount(current) > result[0] ) {
            result[0] = current.length();
            return;
        }
        if(index == arr.size()){
            return;
        }
        maxUnique(arr, index, current, result);
        maxUnique(arr, index, current +arr.get(index), result);

    }
    private int uniqueCharsCount(String str){
        char[] count = new char[26];
        for (char c : str.toCharArray()){
            if(count[c-'0'] >0){
                return -1;
            }
        }
        return str.length();

    }
}
