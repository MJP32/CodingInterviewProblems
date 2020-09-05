package Grokking.Ch16_Knapsack;

public class PartitionSet {
    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }

    private boolean canPartition(int[] num) {

        int total = 0;

        for(int i : num)
            total +=i;

        if(total %2 !=0)
            return false;




        return canPartition(num, 0, total, 0 );
    }

    private boolean canPartition(int[] nums, int sum, int total, int index){


        if(sum *2==total){
            return true;
        }

        if(sum *2 > total || index >= nums.length){
            return false;
        }

        boolean foundPartition1 = canPartition(nums, sum, total, index+1 );
        boolean foundPartition2 = canPartition(nums,  sum + nums[index], total, index+1) ;

        return foundPartition1 || foundPartition2;
    }
}
