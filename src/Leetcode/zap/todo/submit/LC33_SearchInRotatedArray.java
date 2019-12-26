package Leetcode.zap.todo.submit;

public class LC33_SearchInRotatedArray {
    public static void main(String[] args) {
        LC33_SearchInRotatedArray lc33 = new LC33_SearchInRotatedArray();
        System.out.println(lc33.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    public int search(int[]nums, int k){
        if(nums == null || nums.length ==0 )
            return -1;


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

        int start = left;
        left =0;
        right =nums.length-1;
        if(k >= nums[start] && k <= nums[right]) {
            left = start;
        }
        else{
            right =start;
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
