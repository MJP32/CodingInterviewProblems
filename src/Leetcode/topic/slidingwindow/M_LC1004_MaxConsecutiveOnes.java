package Leetcode.topic.slidingwindow;

public class M_LC1004_MaxConsecutiveOnes {
    public static void main(String[] args) {
    /*
    Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

    Return the length of the longest (contiguous) subarray that contains only 1s.

    Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    Output: 6
    Explanation:
    [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
     */

        //System.out.println(new M_LC1004_MaxConsecutiveOnes().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(new M_LC1004_MaxConsecutiveOnes().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(new M_LC1004_MaxConsecutiveOnes().longestOnes(new int[]{1,0,1,1,0}, 1));
        System.out.println(new M_LC1004_MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));

    }
    public int longestOnes(int[] A, int K) {
        int windowStart = 0;
        int windowEnd = 0;
        for ( windowEnd = 0; windowEnd < A.length; windowEnd++) {
            // If we included a zero in the window we reduce the value of K.
            // Since K is the maximum zeros allowed in a window.
            if (A[windowEnd] == 0){
                K--;
            }
            // A negative K denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (K < 0) {
                // If the left element to be thrown out is zero we increase K.
                if (A[windowStart] == 0){
                    K++;
                }
                windowStart++;
            }
        }
        return windowEnd - windowStart;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int windowStart =0;
        int windowEnd = 0;
        int k =1;
        for(windowEnd =0;windowEnd < nums.length;windowEnd++){

            if(nums[windowEnd] == 0){
                k--;
            }

            if(k < 0){
                if(nums[windowStart] == 0){
                    k++;
                }
                windowStart++;
            }
        }

        return windowEnd - windowStart;
    }
}
