package Leetcode;

import java.util.*;

public class LC15_ThreeSum {
    public static void main(String[] args) {
        LC15_ThreeSum lc15= new LC15_ThreeSum();

        List<List<Integer>> results = lc15.threeSum(new int[]{-1,0,1,2,-1,-4});


        System.out.println("");
    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (Integer i : nums){
            set.add(i);

        }
        set.forEach(k-> System.out.println(k + " "));


        int[] arr = new int[set.size()];

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if(i < arr.length -2 || arr[i] != arr[i+1]){
                int start = i +1;
                int end = arr.length -2;

                while(start < end){
                    if(arr[i] + arr[start] + arr[end] ==0){
                        results.add(Arrays.asList(arr[i], arr[start],arr[end]));
                        i++;
                    }
                    else if(arr[i] + arr[start] + arr[end] <0){
                        start++;
                    }
                    else{
                        end--;
                    }
                }

            }
        }


        return results;
    }
}
