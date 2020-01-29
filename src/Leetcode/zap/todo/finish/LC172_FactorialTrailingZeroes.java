package Leetcode.zap.todo.finish;

public class LC172_FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(new LC172_FactorialTrailingZeroes().trailingZeroes(13));
    }

    public  int trailingZeroes(int n) {


        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);

    }

    public  long getFactorial(int n ){

        int i;
                long fact=1;

        for(i=1;i<=n;i++){
            fact=fact*i;
            System.out.println(fact);
        }

        return fact;
    }
}
