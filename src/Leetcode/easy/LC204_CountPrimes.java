package Leetcode.easy;

import java.util.Arrays           ;

public class LC204_CountPrimes {
    public static void main(String[] args) {
        LC204_CountPrimes lc204 = new LC204_CountPrimes();

        System.out.println(lc204.countPrimes(10));
    }

    public int countPrimes(int n) {
        boolean[] primes =  new boolean[n];

        Arrays.fill(primes, true);


        for (int i = 2; i *i < primes.length ; i++) {
            if(primes[i])
                for (int j = i; j*i < primes.length ; j++) {
                    primes[i*j] = false;
                }
        }

        int count =0;

        for (int i = 2; i < primes.length; i++) {
            if(primes[i])
                count++;
        }


        System.out.println(Arrays.toString(primes));
        return count;
    }
}
