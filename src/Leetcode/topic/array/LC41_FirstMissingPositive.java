package Leetcode.topic.array;

public class LC41_FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(new LC41_FirstMissingPositive().firstMissingPositive(new int []{7,-2,3,1,2,20,-5}));
    }
    public int firstMissingPositive(int[] nums) {

        //any negative or value greater than nums.length set to 1

        int containsOne = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] ==1){
                containsOne =1;
            }
            else if(nums[i] <= 1 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }
        if(containsOne ==0){
            return 1;
        }

        //step 2
        for (int i = 0; i < nums.length; i++) {

            int index  = Math.abs(nums[i])-1;

            if(nums[index] >0){
                nums[index] = -1 * nums[index];
            }
        }

        //step 3
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                return i+1;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return nums.length +1;

    }
}
