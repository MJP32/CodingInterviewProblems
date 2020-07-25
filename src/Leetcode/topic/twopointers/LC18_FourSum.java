package Leetcode.topic.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_FourSum {
    public static void main(String[] args) {
        LC18_FourSum lc15 = new LC18_FourSum();

        lc15.threeSum(new int[]{1, 0, -1, 0, -2, 2}, 0).forEach(k -> System.out.println(k));
    }


    public List<List<Integer>> threeSum(int[] nums, int target) {


        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i+1; j < nums.length; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int start = j + 1;
                        int end = nums.length - 1;

                        int res = target-(nums[i]+nums[j]);
                        while (start < end) {
                            int sum =  nums[start] + nums[end];
                            if (res ==sum){
                                results.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                                while (start < end && nums[start] == nums[start + 1]) start++;
                                while (start < end && nums[end] == nums[end - 1]) end--;

                                start++;
                                end--;
                            }
                            else if (res > sum) {
                                start++;
                            } else if (res < sum) {
                                end--;
                            }
                        }
                    }
                    //results.add(four);
                }

            }
        }


        return results;
    }
}
