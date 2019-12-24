package Leetcode.zap.todo.submit;

import java.util.HashSet;

public class LC202_HappyNumber {
    public static void main(String[] args) {
        LC202_HappyNumber lc202 = new LC202_HappyNumber();
        System.out.println(lc202.isHappy(19));
    }
    public boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while(n!=1){


            int current = n;
            int sum =0;

            while(current !=0){
                sum = (current%10)* (current%10);
                current /=10;
            }

            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);

            n= sum;

        }
        return true;

    }
}
