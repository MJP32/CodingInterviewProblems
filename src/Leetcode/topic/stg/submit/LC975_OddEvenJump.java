package Leetcode.topic.stg.submit;

import java.util.Map;
import java.util.TreeMap;

public class LC975_OddEvenJump {
    public static void main(String[] args) {
        System.out.println(new LC975_OddEvenJump().oddEvenJumps(new int[]{10,13,12,14,15}));
    }
    public int oddEvenJumps(int[] A) {
        int goodIndexCount = 1;
        int n = A.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];

        higher[n-1] = true;
        lower[n-1] = true;

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(A[n-1], n-1);

        for (int i = n -2;i>=0;i--){
            Map.Entry higherKeyValuepair = treeMap.ceilingEntry(A[i]);
            Map.Entry lowerKeyValuepair = treeMap.floorEntry(A[i]);

            if(higherKeyValuepair != null){
                higher[i] = lower[(int) higherKeyValuepair.getValue()];
            }
            if (lowerKeyValuepair != null) {
                lower[i] = higher[(int) lowerKeyValuepair.getValue()];
            }
            if(higher[i]){
                goodIndexCount++;
            }
            treeMap.put(A[i], i);


        }
        return goodIndexCount;
    }
}
