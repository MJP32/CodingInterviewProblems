package Leetcode.topic.twopointers;

import java.util.Arrays;

public class E_LC455_AssignCookies {
    public static void main(String[] args) {
     /*

     Given children greed factor and cookies, count how many children can be content.


         Input: [1,2,3], [1,1]

        Output: 1

        Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
        And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
        You need to output 1.


     */
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildrenCount = 0;

        // two pointers
        int i=g.length-1;
        int j=s.length-1;

        while(i >= 0 && j >= 0){
            if(s[j] >= g[i]){
                contentChildrenCount++;
                i--;
                j--;
            }
            else{
                // go the next child, without moving the cookie
                i--;
            }
        }

        return contentChildrenCount;
    }
}
