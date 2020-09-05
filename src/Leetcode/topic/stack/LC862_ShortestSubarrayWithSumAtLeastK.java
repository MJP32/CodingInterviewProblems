package Leetcode.topic.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC862_ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        System.out.println(new LC862_ShortestSubarrayWithSumAtLeastK().shortestSubarray(new int[]{2, -1, 2}, 3));
    }

    public int shortestSubarray(int[] A, int K) {

        int n = A.length;
        int runningSum = 0;
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            runningSum += A[i - 1];
            prefixSum[i] = runningSum;

        }
        int ans = n + 1;
        Deque<Integer> startIndices = new ArrayDeque<>();
        startIndices.add(0);

        for (int endIdx = 0; endIdx <= n; endIdx++) {
            while (!startIndices.isEmpty() && prefixSum[endIdx] - prefixSum[startIndices.peekFirst()] >= K) {
                ans = Math.min(ans, endIdx - startIndices.pollFirst());
            }

            while (!startIndices.isEmpty() && prefixSum[startIndices.peekFirst()] >= prefixSum[endIdx]) {
                startIndices.pollLast();
            }
            startIndices.addLast(endIdx);
        }
        return ans == n + 1 ? -1 : ans;
    }
}
