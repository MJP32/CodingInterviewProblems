package Leetcode.zap.todo.review;


/*Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC159_LongestSubstringWithAtMostTwoDistinctChars {
    public static void main(String[] args) {

        System.out.println(new LC159_LongestSubstringWithAtMostTwoDistinctChars().lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(new LC159_LongestSubstringWithAtMostTwoDistinctChars().lengthOfLongestSubstringTwoDistinct("ccaabbb"));

    }
    /*The idea is to keep iterating through the string and adding each element into the set.
        If set has more than two elements, we want to figure out what element needs to be removed, which would be the element that doesn't match the last iterated characted in the string
        Once the character that needs to be removed is found, remove it from set, and advance the ith position to the latest + 1th occurrence of that element.*/
    public int lengthOfLongestSubstringTwoDistinct(String s) {


        Set<Character> set = new HashSet<>();
        int i=0; int j=0;
        int maxLength = 0;
        while( j<s.length()){
            set.add(s.charAt(j));
            if(set.size()>2){
                char lastchar = s.charAt(j-1);
                // find out the element that needs to be removed that doesn't match the last character
                while(s.charAt(i)==lastchar){
                    i=i+1;
                }
                //once the character that needs to be removed is found, remove it from set,
                // and advance the ith position to the latest + 1 occurrence of that element.
                char removechar = s.charAt(i);
                set.remove(removechar);
                int k=i;
                while(k<=j-1){
                    if(s.charAt(k)==removechar){
                        i=k+1;
                    }
                    k++;
                }
            }
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        return maxLength;

    }
}
