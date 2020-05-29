package Leetcode.zap.todo.review.facebook.mock;

import java.util.*;

public class LC1213_IntersectionOf3SortedArrays {
    public static void main(String[] args) {
     new LC1213_IntersectionOf3SortedArrays().arraysIntersection(new int[]{1,2,3,4,5}, new int[]{1,2,5,7,9}, new int[]{1,3,4,5,8}).forEach(k-> System.out.println(k));
    }
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i =0;i < arr1.length;i++){
            map.put(arr1[i], 1);
        }
        for (int i =0;i < arr2.length;i++){
            if(map.containsKey(arr2[i])){
                map.put(arr2[i], map.get(arr2[i]) +1);
            }
        }

        for (int i =0;i < arr3.length;i++){
            if(map.containsKey(arr3[i])){
                map.put(arr3[i], map.get(arr3[i]) +1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() ==3) {
                list.add(entry.getKey());
            }

        }

        Collections.sort(list);
        return list;
    }
}
