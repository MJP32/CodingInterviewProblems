package Leetcode.topic.greedy;

public class LC670_MaximumSwap {
    public static void main(String[] args) {
//        System.out.println(new LC670_MaximumSwap().maximumSwap(2736));
        System.out.println(new LC670_MaximumSwap().maximumSwap(9937));
    }
    public int maximumSwap(int num) {

        char max =' ';
        int index = 0;

        char[] nums = Integer.toString(num).toCharArray();

        for(int i=0;i< nums.length; i++){
            for(int j= nums.length-1; j >i; j--){
                if( nums[j] > nums[i]){
                    if(nums[j] > max){
                        max = nums[j];
                        index = j;
                    }
                }
            }
            if(max != ' '){
                char tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                return Integer.valueOf(new String(nums));
            }
        }

        return num;
    }
}
