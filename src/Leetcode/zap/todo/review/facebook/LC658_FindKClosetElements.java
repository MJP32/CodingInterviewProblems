package Leetcode.zap.todo.review.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC658_FindKClosetElements {
    public static void main(String[] args) {
        new LC658_FindKClosetElements().findClosestElements(new int []{1,2,3,4,5}, 4, 3).forEach(k-> System.out.println(k));
        new LC658_FindKClosetElements().findClosestElements(new int []{1,2,3,4,5}, 4, -1).forEach(k-> System.out.println(k));
//        new LC658_FindKClosetElements().findClosestElements(new int []{1,2,3,4,5}, 4, 3).forEach(k-> System.out.println(k));
//        new LC658_FindKClosetElements().findClosestElements(new int []{1,2,3,4,5}, 4, 2).forEach(k-> System.out.println(k));
//        new LC658_FindKClosetElements().findClosestElements(new int []{1,2,3,4,5}, 4, 1).forEach(k-> System.out.println(k));
//        new LC658_FindKClosetElements().findClosestElements(new int []{1,2,3,4,5}, 4, -1).forEach(k-> System.out.println(k));
//        new LC658_FindKClosetElements().findClosestElements(new int []{1,2,3,4,5}, 4, 10).forEach(k-> System.out.println(k));
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();
        int start = binarySearch(arr, x);
        int i = start;
        int j = start;

       findClosestElements(start, x, k , arr, result);

        return result;
    }

    public static List<Integer> findClosestElements(int mid,int target, int count, int[] arr, List<Integer> list) {
        int left = mid;
        int right = mid + 1;
        while (count > 0) {
            if (left >= 0 && right <= arr.length - 1) {
                if (target - arr[left] <= arr[right] - target) {
                    left--;
                    count--;
                } else {
                    right++;
                    count--;
                }
            } else if (left < 0 && right <= arr.length - 1) {
                // means right remain num
                right++;
                count--;
            } else if (left >= 0 && right > arr.length - 1) {
                // means left remain num
                left--;
                count--;
            }
        }
        // beagin to fill num
        left++;
        right--;
        for (int i = left; i <= right && left >= 0 && right <= arr.length - 1; i++) {
            list.add(arr[i]);
        }

        return list;
    }

    private int binarySearch(int[] arr, int x) {
        int index;

        int start = 0;
        int end = arr.length;

        int mid=0;
        while(start < end){
            mid = (start + end)/2;


            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] < x){
                start = mid +1;
            }
            else{
                end = mid -1;
            }



        }

        return mid;

    }
}
