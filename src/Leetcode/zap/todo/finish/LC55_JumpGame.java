package Leetcode.zap.todo.finish;

public class LC55_JumpGame {
    public static void main(String[] args) {

        LC55_JumpGame lc55 = new LC55_JumpGame();
        System.out.println(lc55.canJump(new int[]{2,3,1,1,4}));
        System.out.println(lc55.canJump(new int[]{3,2,1,0,4}));
    }
    public boolean canJump(int[] nums) {

        int lastIndexCanJump = nums.length -1;


        for (int i = nums.length -1; i >=0 ; i--) {

            System.out.println(i + nums[i] + " " + lastIndexCanJump);
            if(i + nums[i] >= lastIndexCanJump){
                lastIndexCanJump =i;
            }
            else{
                return false;
            }

        }

        return lastIndexCanJump ==0;


    }
}
