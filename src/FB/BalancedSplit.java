package FB;

import java.util.Arrays;

public class BalancedSplit {
    public static void main(String[] args) {
        System.out.println(new BalancedSplit().balancedSplitExists(new int[]{1, 5, 7, 1}));
        System.out.println(new BalancedSplit().balancedSplitExists(new int[]{12, 7, 6, 7, 6}));
    }
    boolean balancedSplitExists(int[] arr) {
        // Write your code here
        Arrays.sort(arr);
        int left =0;
        int right = arr.length-1;

        int leftSum =0;
        int rightSum =0;
        while(left <= right){

            if(leftSum < rightSum){
                leftSum += arr[left++];
            }
            else if(rightSum > leftSum){
                rightSum += arr[right--];
            }
            else{
                leftSum += arr[left++];
                rightSum += arr[right--];
            }

            if(leftSum == rightSum && left-1  == right && arr[left-1]< arr[right+1]){
                return true;
            }
        }

        System.out.println(leftSum +" "+rightSum);
        System.out.println(left +" "+right);
        return false;
    }
}
