package AlgoExpert.DP;

import java.util.Arrays;

public class MinNumberOfJumps {
    public static void main(String[] args) {
        System.out.println(minNumberOfJumps(new int[]{3,4,2,1,2,3,7,1,1,1,3}));
    }
    public static int minNumberOfJumps(int[] array) {
        int[] jump = new int[array.length];
        Arrays.fill(jump, Integer.MAX_VALUE);
        jump[0]=0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if(array[j] >= i-j){
                    jump[i]= Math.min(jump[j]+1, jump[i]);
                }

            }

        }

        return jump[jump.length-1];
    }
}
