package Leetcode.topic.sort;

public class LC75_SortColors {
    public static void main(String[] args) {

    }
    public void sortColors(int[] nums) {
        int left =0;
        int right = nums.length-1;
        int i =0;
        while(i <= right){
            if(nums[i] == 0){
                swap(i, left, nums);
                i++;
                left++;

            }
            else if(nums[i] ==1){
                i++;
            }
            else{
                swap(i, right, nums);
                right--;
            }
        }
    }
    private void swap(int i, int right, int[] nums){
        int temp = nums[i];
        nums[i] =nums[right];
        nums[right] = temp;
    }
}
