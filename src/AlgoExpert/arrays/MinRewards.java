package AlgoExpert.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinRewards {
    public static void main(String[] args) {
        System.out.println(minRewards2(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
    }

    public static int minRewards(int[] scores) {

        int[] rewards = new int[scores.length];
        Arrays.fill(rewards,1);
        for (int i = 1; i < scores.length; i++) {
            int j = i - 1;
            if (scores[i] > scores[j]) {
                rewards[i] = rewards[j] + 1;
            } else {
                while (j >= 0 && scores[j] > scores[j + 1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
                    j--;
                }
            }

        }

        return IntStream.of(rewards).sum();
    }

    public static int minRewards2(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        for (int i = 1; i < scores.length; i++){
            if(scores[i] > scores[i-1]){
                rewards[i] =  rewards[i-1] +1;
            }
        }

        for(int i =scores.length-2; i >=0;i--){
            if(scores[i] > scores[i+1]){
                rewards[i] = Math.max(rewards[i], rewards[i+1]+1);
            }
        }

        System.out.println(Arrays.toString(rewards));

        return IntStream.of(rewards).sum();
    }
}
