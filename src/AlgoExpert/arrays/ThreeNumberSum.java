package AlgoExpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeNumberSum {
    public static void main(String[] args) {
        //System.out.println(threeNumberSum(new int[]{12,3,1,2,-6, 5,-8,6 },0));
        threeNumberSum(new int[]{12,3,1,2,-6, 5,-8,6 },0).forEach(k-> System.out.println(Arrays.toString(k)));
        threeNumberSum(new int[]{1,2,3,4 },6).forEach(k-> System.out.println(Arrays.toString(k)));
    }

    public static ArrayList<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        ArrayList<Integer[]> threeNumber = new ArrayList<Integer[]>();
        Integer [] ansArr = new Integer[3];

        for(int i = 0; i < array.length;i++){
            int left = i+1;
            int right = array.length -1;
            while(left < right){
                int sum = array[i] + array[left]+array[right];
                if(sum > targetSum){
                    right--;
                }
                else if(sum < targetSum){
                    left++;
                }
                else{
                    ansArr[0] = array[i];
                    ansArr[1] =array[left];
                    ansArr[2] = array[right];
                    threeNumber.add(ansArr);
                    left++;
                    right--;
                }

            }

        }


        return threeNumber;
    }
}
