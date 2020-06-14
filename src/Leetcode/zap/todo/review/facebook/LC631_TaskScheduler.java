package Leetcode.zap.todo.review.facebook;

import java.util.Arrays;

public class LC631_TaskScheduler {
    public static void main(String[] args) {
        /*Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.
        Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

        However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

        You need to return the least number of intervals the CPU will take to finish all the given tasks.



        Example:

        Input: tasks = ["A","A","A","B","B","B"], n = 2
        Output: 8
        Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
        */
        System.out.println(new LC631_TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
    public int leastInterval(char[] tasks, int n) {

        int[] charMap = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            charMap[tasks[i] -'A']++;

        }
        Arrays.sort(charMap);
        //System.out.println(Arrays.toString(charMap));
        int maxVal = charMap[25]-1;
        int idleSlots = maxVal * n;
        for (int i = 24; i >=0 ; i--) {
            //idleSlots -=Math.min()
        }
        return 1;

    }
}
