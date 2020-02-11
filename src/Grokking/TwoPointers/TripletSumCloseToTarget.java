package Grokking.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }


    public static int searchTriplet(int[] arr, int targetSum) {
        // TODO: Write your code here

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {





            int left= i +1;
            int right = arr.length-1;


            while (left < right) {
                int diff = targetSum -arr[i] - arr[left] - arr[right];
                if(diff ==0){
                    return targetSum -diff;
                }

                // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
                if (Math.abs(diff) < Math.abs(smallestDifference)
                        || (Math.abs(diff) == Math.abs(smallestDifference) && diff > smallestDifference))
                    smallestDifference = diff; // save the closest and the biggest difference


                if(diff > 0 ){
                    left++;
                }
                else{
                    right--;
                }

            }
        }


        return targetSum- smallestDifference;
    }


}
