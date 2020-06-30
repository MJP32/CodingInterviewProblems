package Leetcode.topic.dp;

public class LC887_SuperEggDrop {
    public static void main(String[] args) {
        System.out.println(new LC887_SuperEggDrop().superEggDrop(2,6));
    }
    public int superEggDrop(int K, int N) {
        int eggs = K;
        int floors = N;

        int[][] result = new int[eggs+1][floors+1];

        for (int i = 0; i <= floors; i++) {
            result[1][i] =i;

        }
        int c =0;
        for (int e = 2; e <= eggs; e++) {
            for(int f = 1; f <= floors; f++ ){
                result[e][f] = Integer.MAX_VALUE;
                for (int k =1; k <= f; k++){
                    c = 1 + Math.max(result[e-1][k-1], result[e][f-k]);
                    if(c < result[e][f]){
                        result[e][f] =c;
                    }
                }
            }

        }
        return result[eggs][floors];
    }
}
