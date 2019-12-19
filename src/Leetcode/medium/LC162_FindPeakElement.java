package Leetcode.medium;


public class LC162_FindPeakElement {

    public static void main(String[] args) {

        LC162_FindPeakElement lc162 = new LC162_FindPeakElement();
        System.out.println(lc162.findPeakElement(new int[]{1,2,1,3,5,6,7,1}));
    }

    public  int findPeakElement(int[] nums) {


        int left =0;
        int right = nums.length -1;

        while(left < right){
            int mid = left + (right -left)/2;
            if(nums[mid]< nums[mid+1]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
