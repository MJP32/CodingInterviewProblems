package Leetcode.topic.template;

public class LC35_SearchInsertPosition {
    public static void main(String[] args) {

        System.out.println(new LC35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(new LC35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(new LC35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(new LC35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 0));
    }
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        int mid =0;
        while(left <= right){
             mid = left + (right -left)/2;

             if(nums[mid] > target){
                 right = mid-1;
             }
             else if(nums[mid] < target){
                 left = mid+1;

             }
             else{
                 return mid;
             }

        }

        return left;
    }
}
