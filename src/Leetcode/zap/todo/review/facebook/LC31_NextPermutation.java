package Leetcode.zap.todo.review.facebook;

public class LC31_NextPermutation {
    public static void main(String[] args) {
int[] arr1 = new int[]{1,3,2};
int[] arr2 = new int[]{1,2,3};
int[] arr3 = new int[]{3,2,1};
int[] arr4 = new int[]{1,5,8,4,7,6,5,3,1};

new LC31_NextPermutation().nextPermutation(arr1);
new LC31_NextPermutation().nextPermutation(arr2);
new LC31_NextPermutation().nextPermutation(arr3);
new LC31_NextPermutation().nextPermutation(arr4);

    }
    public void nextPermutation(int[] nums) {

        int index = getPivot(nums);
        System.out.println("-> "+index);

        if (index != -1) {
            int higherIndex = getNextHighestIndxx(index, nums);
            System.out.println(higherIndex);
        }

    }

    private int getNextHighestIndxx(int index, int[] nums) {

        for (int i = index+1; i < nums.length; i++) {
            if(nums[index] > nums[i]){
                return i-1;
            }

        }

        return -1;

    }

    private int getPivot(int[] nums) {

        for (int i = nums.length-1; i >0; i--) {
            if (nums[i-1] <nums[i]) {
                return i-1;
            }

        }
        return -1;
    }

}
