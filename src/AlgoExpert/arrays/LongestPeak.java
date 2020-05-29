package AlgoExpert.arrays;

public class LongestPeak {
    public static void main(String[] args) {
        System.out.println(longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
    }
    public static int longestPeak(int[] array) {
        int maxPeak =0;
        for(int i =1; i < array.length -1;i++){
            if(array[i-1] < array[i]  && array[i] >array[i+1]){
                int left =i;
                while(left > 0 && array[left-1]< array[left]){
                    left--;
                }



                int right =i;
                while(right < array.length-1 && array[right]> array[right+1]){
                    right++;
                }



                maxPeak = Math.max(maxPeak, (right-left+1));
            }

        }
        return maxPeak;
    }
}
