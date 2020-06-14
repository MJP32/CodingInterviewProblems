package AlgoExpert.DP;

public class MinNumberOfJumps2 {
    public static void main(String[] args) {
        //System.out.println(minNumberOfJumps(new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3}));
        System.out.println(minNumberOfJumps(new int[]{3,2,1,0,4}));
        System.out.println(minNumberOfJumps(new int[]{1,2}));
    }

    public static int minNumberOfJumps(int[] array) {
        int jumps = 0;
        int steps = array[0];
        int maxReach=array[0];
        for (int i = 1; i < array.length-1; i++) {
            maxReach=Math.max(maxReach,array[i]+i);
            steps--;
            if(steps ==0){
                jumps++;
                steps = maxReach -i;
            }
        }
        return jumps+1;
    }
}
