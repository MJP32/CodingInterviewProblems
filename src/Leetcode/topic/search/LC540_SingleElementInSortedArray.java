package Leetcode.topic.search;

public class LC540_SingleElementInSortedArray {

    public static void main(String[] args) {

        //System.out.println(new LC540_SingleElementInSortedArray().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(new LC540_SingleElementInSortedArray().singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = left + (right -left)/2;
            boolean isEven = (right - mid)%2 ==0;

            if(nums[mid - 1] == nums[mid]){
                if (isEven) {
                    right = mid -2;
                }
                else{
                    left = mid +1;
                }
            }
            else if (nums[mid +1] == nums[mid]) {
                if (isEven) {
                    left = mid +2;
                }
                else{
                    right = mid -1;
                }
            }
            else{
                return nums[mid];
            }
        }
        return nums[left];
    }
}
