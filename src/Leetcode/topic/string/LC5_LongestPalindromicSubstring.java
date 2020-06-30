package Leetcode.topic.string;

public class LC5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        /*
            Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

            Example 1:

            Input: "babad"
            Output: "bab"
            Note: "aba" is also a valid answer.
            Example 2:

            Input: "cbbd"
            Output: "bb"

         */


        LC5_LongestPalindromicSubstring lp = new LC5_LongestPalindromicSubstring();
        System.out.println(lp.longestPalindrome("aaracecar"));
    }

    public String longestPalindrome(String s) {

        if(s ==null ){
            return null;
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length()-1; i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);

            int maxLen = Math.max(len1,len2);



            if(maxLen > right-left){
                left = i-((maxLen -1)/2);
                right = i+(maxLen /2);

            }

        }

        return s.substring(left,right+1);


    }

    private int expandFromMiddle(String s, int left, int right) {


        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){

            left--;
            right++;
        }

        return right-left-1;

    }
}
