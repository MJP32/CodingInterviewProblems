package Leetcode.zap.todo.review;

public class LC540_SingleElementInSortedArray {
    public static void main(String[] args) {

        System.out.println(new LC540_SingleElementInSortedArray().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(new LC540_SingleElementInSortedArray().singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }

    public int singleNonDuplicate(int[] nums) {

        int lo = 0;
        int hi = nums.length -1;

        while(lo < hi){
            int mid = (lo + (hi -lo))/2;

            boolean halvesEven = (hi - mid)%2 ==0;

            if (nums[mid +1] == nums[mid]) {
                if (halvesEven) {
                    lo = mid +2;
                }
                else{
                    hi = mid -1;
                }

            }
            else if(nums[mid - 1] == nums[mid]){
                if (halvesEven) {
                    hi = mid -2;
                }
                else{
                    lo = mid +1;
                }
            }
            else{
                return nums[mid];
            }

        }

        return nums[0];


    }
}
