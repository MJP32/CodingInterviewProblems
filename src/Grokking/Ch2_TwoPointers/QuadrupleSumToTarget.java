package Grokking.Ch2_TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {

    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {

        List<List<Integer>> quadruplets = new ArrayList<>();

        Arrays.sort(arr);

        //-3,-1,1,1,2,4
        for (int i = 0; i < arr.length - 3; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate quadruplets
                continue;


            for (int j = i+1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) // skip same element to avoid duplicate quadruplets
                    continue;

                searchPairs(arr, target, quadruplets, i, j);

            }
        }



        return quadruplets;
    }

    private static void searchPairs(int[] arr, int target, List<List<Integer>> quadruplets, int i, int j) {
        int left = j+1;
        int right = arr.length-1;


        while (left < right) {

            int sum = arr[i] +arr[j] + arr[left] + arr[right];
            if (sum == target) {


                quadruplets.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                right--;
                left++;
                while(left< right && arr[left] == arr[left-1]){
                    left++;
                }
                while(left< right && arr[right] == arr[right+1]){
                    right--;
                }

            } else if (sum < target) {
                left++;
            }
            else{
                right--;
            }



        }
    }
}
