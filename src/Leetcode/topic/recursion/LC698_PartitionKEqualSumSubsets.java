package Leetcode.topic.recursion;

public class LC698_PartitionKEqualSumSubsets {
    public static void main(String[] args) {
        System.out.println(new LC698_PartitionKEqualSumSubsets().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;

        for(int i : nums){
            total +=i;
        }

        if (total % k !=0) {
            return false;
        }

        return canPartition(0, nums, new boolean[nums.length], k,0,total/k);
    }

    private boolean canPartition(int iterationStart, int[] nums, boolean[] used, int k, int inProgressBucketSum, int targetBucketSum) {

        if (k ==1) {
            return true;
        }
        if (inProgressBucketSum == targetBucketSum) {
            return canPartition(0, nums, used, k-1, 0, targetBucketSum);


        }

        for (int i = iterationStart; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true; //choose
                if (canPartition(i+1,nums,used, k,inProgressBucketSum +nums[i], targetBucketSum)) {
                    return true;
                }
                used[i] =false; //unchoose
            }

        }
        return false;
    }


}