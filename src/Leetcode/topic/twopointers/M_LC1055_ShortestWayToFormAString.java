package Leetcode.topic.twopointers;

public class M_LC1055_ShortestWayToFormAString {
    public static void main(String[] args) {
/*
From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).

Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.

Input: source = "abc", target = "abcbc"
Output: 2
Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".

 */

        System.out.println(new M_LC1055_ShortestWayToFormAString().shortestWay("abc", "abcbc"));


    }

    public int shortestWay(String source, String target) {
        int count = 0;

        String remaining = target;
        while (remaining.length() > 0) {
            StringBuilder subsequence = new StringBuilder();
            int i =0;
            int j =0;
            while(i < source.length() && j < remaining.length()){
                if (source.charAt(i++) == remaining.charAt(j)) {
                    subsequence.append(remaining.charAt(j++));
                }
            }
            if (subsequence.length() ==0) {
                return -1;
            }
            count++;
            remaining = remaining.substring(subsequence.length());
        }
        
        return count;
    }

}
