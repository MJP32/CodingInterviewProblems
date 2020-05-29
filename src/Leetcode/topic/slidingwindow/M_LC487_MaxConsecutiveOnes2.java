package Leetcode.topic.slidingwindow;

public class M_LC487_MaxConsecutiveOnes2 {
    public static void main(String[] args) {
        /*
        Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

        Input: [1,0,1,1,0]
        Output: 4
        Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
            After flipping, the maximum number of consecutive 1s is 4.

        */
        System.out.println(new M_LC487_MaxConsecutiveOnes2().findMaxConsecutiveOnes(new int []{1,0,1,1,0}));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int windowStart =0;
        int windowEnd = 0;
        int k =1;
        for(windowEnd =0;windowEnd < nums.length;windowEnd++){
            if(nums[windowEnd] == 0){
                k--;
            }
            if(k<0){
                if(nums[windowStart] == 0){
                    k++;
                }
                windowStart++;
            }
        }
        return windowEnd - windowStart;
    }
}
