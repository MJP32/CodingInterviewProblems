package AlgoExpert.assessment;

public class BuildRuns {
    public static void main(String[] args) {
        boolean[][] buildRuns = new boolean[][]{
                {true, true, true, false, false},
                {true, true, true, true, false},
                {true, true, true, true, true, true, false, false, false},
                {true, false,false,false,false,false},
                {true, true,true,true,true,true,true,true,true,true,true,true,false},
                {true,false},
                {true,true,true,true,false,false}
        };
        boolean[][] buildRuns2 = new boolean[][]{
                {true, true, true, false, false},
                {true, true, true, true, false}

        };

        System.out.println(buildFailures(buildRuns));
        System.out.println(buildFailures(buildRuns2));

    }
    public static int buildFailures(boolean[][] buildRuns) {
        // Write your code here.
        double[] percent = new double[buildRuns.length];
        for(int i =0; i < buildRuns.length;i++){
            int trueCount = 0;
            for(int j =0; j < buildRuns[i].length;j++){

                if(buildRuns[i][j]){
                    trueCount++;
                }
            }
            percent[i] = (double)trueCount/buildRuns[i].length;

        }




        //System.out.println(Arrays.toString(percent));
        return findLengthOfLCIS(percent);
    }

    public static int findLengthOfLCIS(double[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }

        int max=-1;
        int curr =-1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]){
                curr++;
            }
            else{
                curr=-1;
            }
            max = Math.max(max, curr);
        }


        if(max == -1){
            return -1;
        }
        return max+2;
    }
}
