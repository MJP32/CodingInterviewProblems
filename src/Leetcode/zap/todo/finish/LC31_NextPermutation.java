package Leetcode.zap.todo.finish;

public class LC31_NextPermutation {
    public static void main(String[] args) {

//        Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

//        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

//        The replacement must be in-place and use only constant extra memory.
        //8, 2, 5, 4, 3, 1
        //8, 3, 5, 4, 2, 1
        //8, 3, 1, 2, 4, 5


        LC31_NextPermutation lc31 = new LC31_NextPermutation();
        lc31.nextPermutation(new int[]{1,2,3});
        lc31.nextPermutation(new int[]{1,1,5});
        lc31.nextPermutation(new int[]{3,2,1});
        lc31.nextPermutation(new int[]{8,2,5,4,3,1});

    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {

        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
