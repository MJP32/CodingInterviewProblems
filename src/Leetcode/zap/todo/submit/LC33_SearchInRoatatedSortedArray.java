package Leetcode.zap.todo.submit;

public class LC33_SearchInRoatatedSortedArray {
    public static void main(String[] args) {
        LC33_SearchInRoatatedSortedArray lc33 =new LC33_SearchInRoatatedSortedArray();
        System.out.println(lc33.search(new int[]{4,5,6,7,0,1,2}, 1));
    }
    public int search(int[] nums, int target) {

        if(nums == null){
            return -1;
        }

        if(nums.length ==1){
            return nums[0];
        }

        int left =0;
        int right = nums.length -1;
        while(left< right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right] ){
                left = mid+1;
            }
            else{
                right =mid;
            }
        }

        int pivot = left;
        left =0;
        right = nums.length -1;

        if(target >= nums[pivot] && target <=nums[right] ){
            left = pivot;
        }
        else{
            right = pivot;
        }

        while(left <=right){
            int mid = left+(right -left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] <target ){
                left = mid+1;

            }
            else{
                right = mid-1;
            }
        }

        return -1;
    }
}
