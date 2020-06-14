package AlgoExpert.DP;

public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(10, new int[]{1,5,10}));
    }
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] ways = new int[n+1];
        ways[0] = 1;
        //Arrays.fill(ways,1);
        for(int denom : denoms){
            for(int i =1;i< n+1;i++){
                if(denom <=i)
                    ways[i] += ways[i-denom];
            }
        }
        return ways[n];
    }
}
