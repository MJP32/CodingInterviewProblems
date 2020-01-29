package Leetcode.zap.todo.finish;

public class LC581_ShortestUnsortedContSubaArr {
    public static void main(String[] args) {

        System.out.println(new LC581_ShortestUnsortedContSubaArr().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
    public int findUnsortedSubarray(int[] nums) {
        int begin= findBegin(nums);
        int end =-1;

        if(begin != -1)
            end = findEnd(nums);


        return end-begin;
    }

    public int findBegin(int[] nums){

        for(int i =0;i< nums.length-1;i++){
            if(nums[i] >nums[i+1]){
                return i;
            }
        }

        return -1;
    }


    public int findEnd(int[] nums){

        for(int i =nums.length-1;i>0 ;i--){
            if(nums[i] < nums[i-1]){
                return i;
            }
        }

        return -1;
    }
}
