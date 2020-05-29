package Leetcode.topic.twopointers;

public class H_LC42_TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(new H_LC42_TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public int trap(int[] height) {

        /**

         */
        int left[] = new int[height.length];
        int right[]= new int[height.length];

        for( int i =0;i<height.length;i++)
        {
            int lIdx = i-1<0?0:i-1;
            left[i] = Math.max(left[lIdx],height[i]);
        }

        for( int i =height.length-1;i>=0;i--)
        {
            int lIdx = i+1>=height.length?height.length-1:i+1;
            right[i] = Math.max(right[lIdx],height[i]);
        }
        int result = 0;
        for(int i =0;i<height.length;i++)
        {
            int curr = Math.min(left[i],right[i]);
            result+=curr-height[i];
        }

        return result;
    }
}
