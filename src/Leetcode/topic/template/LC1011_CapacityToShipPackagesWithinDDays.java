package Leetcode.topic.template;

public class LC1011_CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        System.out.println(new LC1011_CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(new LC1011_CapacityToShipPackagesWithinDDays().shipWithinDays(new int[]{7,2,5,10,8

                }, 2));
    }
    public int shipWithinDays(int[] weights, int D) {
        int left =0;
        int totalWeight =0;

        for(int i : weights){
            totalWeight +=i;
        }
        int right = totalWeight;
        while (left < right) {
            int mid = left+(right -left)/2;
            if (feasible(weights, D, mid)) {
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }
    private boolean feasible(int[] weights, int D,  int capacity){
        int days =1;
        int total =0;
        for (int weight : weights) {
            total += weight;
            if(total > capacity){
                total = weight;
                days++;
                if (days > D) {
                    return false;
                }
            }

        }
        return true;
    }
}
