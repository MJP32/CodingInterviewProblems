package Leetcode.topic.array;

public class LC33_SearchInRotatedArray {
    public static void main(String[] args) {
        LC33_SearchInRotatedArray lc33 = new LC33_SearchInRotatedArray();
        System.out.println(lc33.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(lc33.search(new int[]{9,12,17,2,4,5}, 17));
    }
    public int search(int[]nums, int k){



        int left =0;
        int right = nums.length -1;
        while(left< right){
            int midpoint = left +(right - left)/2;
            if(nums[midpoint] > nums[right]){
                left = midpoint+1;
            }
            else{
                right = midpoint;
            }

        }

        int pivot = left;
        left =0;
        right =nums.length-1;
        if(k >= nums[pivot] && k <= nums[right]) {
            left = pivot;
        }
        else{
            right =pivot-1;
        }

        while(left <= right){
            int midpoint = left+(right-left);
            if(nums[midpoint] == k){
                return midpoint;
            }
            else if(nums[midpoint] < k){
                left = midpoint +1;
            }
            else{
                right = midpoint -1;
            }
        }

        return -1;
    }
}
