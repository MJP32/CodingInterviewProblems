package Leetcode.topic.template;

public class LC1482_MinimumNumberofDaystoMakemBouquets {
    public static void main(String[] args) {

    }
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        int left =0;
        int right =1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(feasible(bloomDay, m, mid)){
                right = mid;
            }
            else {
                left = mid +1;
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
