package Leetcode.zap;

public class LC11_ContaineWithMostwater {
    public static void main(String[] args) {
        LC11_ContaineWithMostwater lc11 =new LC11_ContaineWithMostwater();
        System.out.println(lc11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;




        return max;
    }

    public int maxAreaBruteForce(int[] height) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int shortWall = Math.min(height[i],height[j]);


                max = Math.max(max,shortWall * (j-i));

            }

        }

        return max;
    }
}
