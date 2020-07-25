package Leetcode.topic.stg;

public class LC1060_MissingElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(new LC1060_MissingElementInSortedArray().missingElement(new int[]{4, 7, 9, 10}, 3));
    }

    public int missingElement(int[] nums, int k) {

        int n = nums.length;
        int missingNum = missing(n - 1, nums);
        if (k > missingNum) {
            return nums[n - 1] + k - missing(n - 1, nums);
        }


        int left = 0;

        int right = n - 1;
        int mid;

        while (left != right) {
            mid = left + (right - left) / 2;
            missingNum = missing(mid, nums);
            if (missingNum < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        missingNum = missing(left - 1, nums);
        return nums[left - 1] + k - missingNum;

    }

    int missing(int idx, int[] nums) {
        int missingNim = nums[idx] - nums[0] - idx;
        return missingNim;
    }
}
