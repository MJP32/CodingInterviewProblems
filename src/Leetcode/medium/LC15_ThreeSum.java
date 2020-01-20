package Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_ThreeSum {
    public static void main(String[] args) {
        LC15_ThreeSum lc15= new LC15_ThreeSum();


//        lc15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        lc15.threeSum(new int[]{0,0,0,0});
        lc15.threeSum(new int[]{-2,0,0,2,2});
    }


    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {

            if(i==0 || (i>0&& nums[i] != nums[i-1])) {
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int currSum = nums[i] + nums[start] + nums[end];

                    if (currSum > 0) {
                        end--;
                    } else if (currSum < 0) {
                        start++;
                    } else if (currSum == 0) {


                        results.add(Arrays.asList(nums[i], nums[start], nums[end]));

                        while (start < end && nums[start] == nums[start + 1])
                            start++;
                        while (start < end && nums[end] == nums[end - 1])
                            end--;

                        end--;
                        start++;

                    }
                }
            }

        }


        results.forEach(k-> System.out.println(k));

        return results;
    }
}
