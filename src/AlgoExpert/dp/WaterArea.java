package AlgoExpert.dp;

public class WaterArea {
    public static void main(String[] args) {
        System.out.println(waterArea(new int[]{0,8,0,0,5,0,0,10,0,0,1,1,0,3}));
    }
    public static int waterArea(int[] heights) {
        int start =0;

        int[] leftMaxArr = new int [heights.length];
        int[] rightMaxArr = new int [heights.length];

        int leftMax = 0;
        for(int i =0; i < heights.length; i++){
            leftMax= Math.max(leftMax, heights[i]);
            leftMaxArr[i] = leftMax;

        }

        int rightMax = 0;
        for(int i =heights.length -1; i >= 0; i--){
            rightMax= Math.max(rightMax, heights[i]);
            rightMaxArr[i] = rightMax;

        }



        for(int i =0; i < heights.length; i++){
            int lowerHeight = Math.min(leftMaxArr[i], rightMaxArr[i]);
            if(heights[i] < lowerHeight){
                heights[i] = lowerHeight - heights[i];
            }
            else{
                //needed to exclude pillars
                heights[i] =0;
            }

        }

        int total = 0;
        for (int height: heights){
            total += height;
        }



        return total;

    }
}
