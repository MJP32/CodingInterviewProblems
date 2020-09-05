package AlgoExpert.assessment;

public class LongestStreakOfAdjacentOnes {
    public static void main(String[] args) {
        int [] array = new int[]{1,0,1,1,0,0,1,1,0,1,1,1,0,1};


    }
    public static int longestStreakOfAdjacentOnes(int[] array) {
        if(array.length ==0)
            return 0;
        else if(array.length ==1)
            return array[0];

        int max = 0;
        int maxIdx = -1;
        int currMax = 0;
        int currIdx = -1;

        for(int i =0; i < array.length; i++){
            if(array[i] == 1){
                currMax++;
            }
            else{
                currMax =i - currIdx;
                currIdx = i;
            }
            if(currMax > max){
                max = currMax;
                maxIdx = currIdx;

            }


        }

        return maxIdx;
    }
}
