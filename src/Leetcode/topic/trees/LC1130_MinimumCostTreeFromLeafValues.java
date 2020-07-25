package Leetcode.topic.trees;

import java.util.HashMap;
import java.util.Map;

public class LC1130_MinimumCostTreeFromLeafValues
{
    public static void main(String[] args) {
        System.out.println(new LC1130_MinimumCostTreeFromLeafValues().mctFromLeafValues(new int[]{6,2,4}));
    }

    public int mctFromLeafValues(int[] arr) {
        int[] res = dfs(0, arr.length-1, arr, new HashMap<>());
        return res[1];
    }

    private int[] dfs(int left, int right, int[] arr, Map<String, int[]> map) {
        if (left == right) return new int[] {arr[left], 0};
        String key = left + ":" + right;
        if (map.containsKey(key)) return map.get(key);
        int max = Integer.MAX_VALUE, sum = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            int[] leftSub = dfs(left, i, arr, map);
            int[] rightSub = dfs(i+1, right, arr, map);
            int temp = leftSub[1] + rightSub[1] + leftSub[0] * rightSub[0];
            if (temp <= sum) {
                sum = temp;
                int curr = Math.max(leftSub[0], rightSub[0]);
                if (curr < max) max = curr;
            }
        }
        map.put(key, new int[] {max, sum});
        return new int[] {max, sum};
    }
}
