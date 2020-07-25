package Leetcode.topic.array;

public class LC81_SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
//        System.out.println(new LC81_SearchInRotatedSortedArray2().search(new int[]{2,5,6,0,0,1,2}, 0));
//        System.out.println(new LC81_SearchInRotatedSortedArray2().search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(new LC81_SearchInRotatedSortedArray2().search(new int[]{1,3}, 3));

    }
    public boolean search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
                // Ascending from mid to right.
            } else if (nums[mid] < nums[right]) {
                // If the target is within the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                // Ascending from left to mid.
            } else if (nums[mid] > nums[right]) {
                // Look if number is in the left half.
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // nums[mid] == nums[right], move mid one to the left.
                right--;
            }
        }
        return false;
    }

}
