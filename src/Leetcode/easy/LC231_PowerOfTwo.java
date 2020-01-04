package Leetcode.easy;

public class LC231_PowerOfTwo {
    public static void main(String[] args) {
        LC231_PowerOfTwo lc231 = new LC231_PowerOfTwo();
        System.out.println(lc231.isPowerOfTwo(16));
        System.out.println(lc231.isPowerOfTwo(17));
    }
    public boolean isPowerOfTwo(int n) {

        while(n >= 1){
            if(n ==1){
                return true;
            }
            if(n%2 !=0){
                return false;
            }

            n= n/2;

        }


        return false;
    }
}
