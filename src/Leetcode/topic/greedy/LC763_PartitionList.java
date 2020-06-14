package Leetcode.topic.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC763_PartitionList {
    public static void main(String[] args) {
        /*
             A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

            Example 1:

            Input: S = "ababcbacadefegdehijhklij"
            Output: [9,7,8]
            Explanation:
            The partition is "ababcbaca", "defegde", "hijhklij".
            This is a partition so that each letter appears in at most one part.
            A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.


        */

        new LC763_PartitionList().partitionLabels("ababcbacadefegdehijhklij").forEach(k-> System.out.println(k));
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> partitionLengths = new ArrayList<>();
        int[] lastIndexes = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexes[S.charAt(i)-'a'] =i;
        }
        System.out.println(Arrays.toString(lastIndexes));
        int start = 0;
        int end =0;

        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndexes[S.charAt(i) -'a']);
            if(i == end){
                partitionLengths.add(end- start +1);
                start = end+1;
            }
        }

        return partitionLengths;
    }
}
