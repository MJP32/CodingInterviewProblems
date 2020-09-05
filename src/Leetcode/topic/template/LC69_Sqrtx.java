package Leetcode.topic.template;

public class LC69_Sqrtx {
    public static void main(String[] args) {
        System.out.println(new LC69_Sqrtx().mySqrt(8));
    }
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        long num;
        int pivot, left =2,right =x/2;

        while(left <= right){
            pivot = left + (right- left)/2;
            num = pivot*pivot;
            if (num > x) {
                right = pivot-1;
            }
            else if(num < x){
                left = pivot+1;
            }
            else{
                return pivot;
            }
        }

        return right;
    }
}
