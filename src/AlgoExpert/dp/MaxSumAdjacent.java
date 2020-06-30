package AlgoExpert.dp;

public class MaxSumAdjacent {
    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{75,105,120,75,90,135}));
    }
    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if(array.length == 0){
            return 0;

        }
        else if(array.length ==1){
            return array[0];
        }
        int[] maxSums = array.clone();
        maxSums[1]= Math.max(array[0], array[1]);
        for(int i =2; i< array.length;i++){
            maxSums[i]= Math.max(maxSums[i-1], maxSums[i-2]+array[i]);
        }

        return maxSums[array.length-1];
    }
}
